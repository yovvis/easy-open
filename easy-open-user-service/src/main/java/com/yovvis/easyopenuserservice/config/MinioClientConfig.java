package com.yovvis.easyopenuserservice.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio对象存储配置
 *
 * @author yovvis
 * @date 2024/5/25
 */
@Configuration
@ConfigurationProperties(prefix = "s3.client.minio")
@Data
public class MinioClientConfig {
    /**
     * accessKey
     */
    private String accessKey;

    /**
     * secretKey
     */
    private String secretKey;

    /**
     * 端点
     */
    private String endpoint;

    /**
     * 桶名
     */
    private String bucket;

    @Bean
    public MinioClient minioClient() {
        // 初始化用户身份信息(secretId, secretKey)
        MinioClient minioClient = MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
        return minioClient;
    }
}
