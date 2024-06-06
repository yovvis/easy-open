package com.yovvis.easyopenapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户服务
 */
@FeignClient(name = "easy-open-oss-service", path = "/api/oss/inner")
public interface FileFeignClient {

    /**
     * 上传文件信息
     *
     * @param multipartFile
     * @param biz
     * @return
     */
    @PostMapping(value = "/upload")
    String uploadFile(@RequestPart("file")  MultipartFile multipartFile, @RequestParam("biz") String biz);

}
