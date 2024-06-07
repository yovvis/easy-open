package com.yovvis.easyopenossservice.service.impl;

import cn.hutool.core.io.FileUtil;
import com.yovvis.easyopenapi.client.UserFeignClient;
import com.yovvis.easyopenapi.model.dto.file.UploadFileRequest;
import com.yovvis.easyopenapi.model.entity.User;
import com.yovvis.easyopencommon.common.ErrorCode;
import com.yovvis.easyopencommon.constant.FileConstant;
import com.yovvis.easyopencommon.enums.FileUploadBizEnum;
import com.yovvis.easyopencommon.exception.BusinessException;
import com.yovvis.easyopenossservice.manager.MinioManager;
import com.yovvis.easyopenossservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Arrays;

/**
 * 描述
 *
 * @author yovvis
 * @date 2024/6/4
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private MinioManager minioManager;

    /**
     * @param multipartFile
     * @param uploadFileRequest
     * @return
     */
    public String uploadFile(MultipartFile multipartFile, UploadFileRequest uploadFileRequest) {
        String biz = uploadFileRequest.getBiz();
        FileUploadBizEnum fileUploadBizEnum = FileUploadBizEnum.getEnumByValue(biz);
        if (fileUploadBizEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        validFile(multipartFile, fileUploadBizEnum);
        User loginUser = userFeignClient.getLoginUser();
        // 文件目录：根据业务、用户来划分
        String uuid = RandomStringUtils.randomAlphanumeric(8);
        String filename = uuid + "-" + multipartFile.getOriginalFilename();
        String filepath = String.format("/%s/%s/%s", fileUploadBizEnum.getValue(), loginUser.getId(), filename);
        File file = null;
        try {
            // 上传文件
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            minioManager.uploadObject(filepath, file);
            // 返回可访问地址
            return FileConstant.MINIO_HOST + filepath;
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传失败");
        } finally {
            if (file != null) {
                // 删除临时文件
                boolean delete = file.delete();
                if (!delete) {
                    log.error("file delete error, filepath = {}", filepath);
                }
            }
        }
    }

    /**
     * 校验文件
     *
     * @param multipartFile
     * @param fileUploadBizEnum 业务类型
     */
    private void validFile(MultipartFile multipartFile, FileUploadBizEnum fileUploadBizEnum) {
        // 文件大小
        long fileSize = multipartFile.getSize();
        // 文件后缀
        String fileSuffix = FileUtil.getSuffix(multipartFile.getOriginalFilename());
        final long ONE_M = 1024 * 1024L;
        if (FileUploadBizEnum.USER_AVATAR.equals(fileUploadBizEnum)) {
            if (fileSize > ONE_M) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件大小不能超过 1M");
            }
            if (!Arrays.asList("jpeg", "jpg", "svg", "png", "webp").contains(fileSuffix)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件类型错误");
            }
        }
    }

}
