package com.yovvis.easyopenuserservice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@MapperScan("com.yovvis.easyopenuserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.yovvis")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yovvis.easyopenapi.client"})
public class EasyOpenUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyOpenUserServiceApplication.class, args);
        log.info("\n----------------------------------------------------------\n\t" +
                "【用户服务】 \"(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ\"\n\t" +
                "----------------------------------------------------------");
    }
}
