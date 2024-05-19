package com.yovvis.easyopenapiservice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@MapperScan("com.yovvis.easyopenapiservice.mapper")
@EnableScheduling
@ComponentScan("com.yovvis")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yovvis.easyopenserviceclient.service"})
public class EasyOpenApiServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyOpenApiServiceApplication.class);
        log.info("\n----------------------------------------------------------\n\t" +
                "【接口服务】 \"(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ\"\n\t" +
                "----------------------------------------------------------");
    }
}
