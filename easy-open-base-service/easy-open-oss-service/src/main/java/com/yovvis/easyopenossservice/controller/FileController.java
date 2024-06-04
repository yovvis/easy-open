package com.yovvis.easyopenossservice.controller;

import cn.hutool.core.io.FileUtil;
import com.yovvis.easyopenapi.client.FileFeignClient;
import com.yovvis.easyopenapi.client.UserFeignClient;
import com.yovvis.easyopenapi.model.entity.user.User;
import com.yovvis.easyopencommon.common.BaseResponse;
import com.yovvis.easyopencommon.common.ErrorCode;
import com.yovvis.easyopencommon.common.ResultUtils;
import com.yovvis.easyopencommon.constant.FileConstant;
import com.yovvis.easyopencommon.enums.FileUploadBizEnum;
import com.yovvis.easyopencommon.exception.BusinessException;
import com.yovvis.easyopenossservice.manager.MinioManager;
import com.yovvis.easyopenapi.model.entity.file.UploadFileRequest;
import com.yovvis.easyopenossservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;

/**
 * 文件接口
 */
@RestController
@RequestMapping("/")
public class FileController {

    @Resource
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @param uploadFileRequest
     * @return
     */
    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile multipartFile, UploadFileRequest uploadFileRequest) {
        return fileService.uploadFile(multipartFile, uploadFileRequest);
    }
}
