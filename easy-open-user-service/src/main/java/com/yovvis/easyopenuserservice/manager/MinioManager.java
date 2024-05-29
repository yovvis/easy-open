package com.yovvis.easyopenuserservice.manager;
import com.yovvis.easyopenuserservice.config.MinioClientConfig;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * minio对象存储操作
 *
 * @author yovvis
 * @date 2024/5/25
 */
@Component
public class MinioManager {
    @Resource
    private MinioClientConfig minioClientConfig;

    @Resource
    private MinioClient minioClient;

    /**
     * 上传文件
     *
     * @param key
     * @param file
     */
    public ObjectWriteResponse uploadObject(String key, File file) {
        ObjectWriteResponse objectWriteResponse;
        try {
            UploadObjectArgs args = UploadObjectArgs.builder().bucket(minioClientConfig.getBucket()).object(key).filename(file.getAbsolutePath()).build();
            objectWriteResponse = minioClient.uploadObject(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return objectWriteResponse;
    }
}
