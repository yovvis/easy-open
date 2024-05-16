package com.yovvis.easyopenuserservice;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@MapperScan("com.yovvis.easyopenuserservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.yovvis")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yovvis.easyopenserviceclient.service"})
public class EasyOpenUserServiceApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(EasyOpenUserServiceApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        ConfigurableApplicationContext app = application.run(args);
        Environment env = app.getEnvironment();
        // ip
        String ip = InetAddress.getLocalHost().getHostAddress();
        // port
        String port = env.getProperty("server.port");
        // path
        String path = env.getProperty("server.servlet.context-path");
        if (StrUtil.isBlank(path)) {
            path = "";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "【用户服务】 \"(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ\"\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
    }

}
