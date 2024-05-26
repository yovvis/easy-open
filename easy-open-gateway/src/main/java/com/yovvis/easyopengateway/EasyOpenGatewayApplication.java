package com.yovvis.easyopengateway;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class EasyOpenGatewayApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication application = new SpringApplication(EasyOpenGatewayApplication.class);
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
                "【轻享网关】 \"(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ\"\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "Swagger2文档地址: \t\thttp://localhost:" + port + path + "/doc.html\n\t" +
                "External访问地址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
    }

}
