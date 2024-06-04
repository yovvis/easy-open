package com.yovvis.easyopenapi.client;

import com.yovvis.easyopenapi.config.FeignSupportConfig;
import com.yovvis.easyopenapi.model.entity.file.UploadFileRequest;
import com.yovvis.easyopenapi.model.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

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
