package com.yovvis.easyopenossservice.service;

import com.yovvis.easyopenapi.model.dto.file.UploadFileRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * 描述
 *
 * @author yovvis
 * @date 2024/6/4
 */
public interface FileService {

    /**
     *
     * @param multipartFile
     * @param uploadFileRequest
     * @return
     */
    String uploadFile(MultipartFile multipartFile, UploadFileRequest uploadFileRequest);

}
