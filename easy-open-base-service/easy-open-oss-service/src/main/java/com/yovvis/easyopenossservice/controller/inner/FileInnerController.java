package com.yovvis.easyopenossservice.controller.inner;

import com.yovvis.easyopenapi.client.FileFeignClient;
import com.yovvis.easyopenapi.model.entity.file.UploadFileRequest;
import com.yovvis.easyopenossservice.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 文件接口
 */
@RestController
@RequestMapping("/inner")
public class FileInnerController implements FileFeignClient {

    @Resource
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @param biz
     * @return
     */
    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file")  MultipartFile multipartFile, @RequestParam("biz") String biz) {
        UploadFileRequest uploadFileRequest = new UploadFileRequest();
        uploadFileRequest.setBiz(biz);
        return fileService.uploadFile(multipartFile, uploadFileRequest);
    }
}
