package com.yovvis.easyopenuserservice.wxmp.config;

import com.yovvis.easyopenuserservice.wxmp.handler.LogHandler;
import com.yovvis.easyopenuserservice.wxmp.handler.MessageHandler;
import com.yovvis.easyopenuserservice.wxmp.handler.ScanHandler;
import com.yovvis.easyopenuserservice.wxmp.handler.SubscribeHandler;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

import static me.chanjar.weixin.common.api.WxConsts.EventType;
import static me.chanjar.weixin.common.api.WxConsts.EventType.SUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType.EVENT;

/**
 * @Author Kkuil
 * @Date 2023/9/25
 * @Description 微信mp配置
 */
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(WxMpProperties.class)
public class WxMpConfig {
    /**
     * 日志处理器
     */
    private final LogHandler logHandler;
    /**
     * 消息处理器
     */
    private final MessageHandler messageHandler;
    /**
     * 订阅处理器
     */
    private final SubscribeHandler subscribeHandler;
    /**
     * 扫描处理器
     */
    private final ScanHandler scanHandler;

    /**
     * 微信小程序配置
     */
    private final WxMpProperties properties;

    @Bean
    public WxMpService wxMpService() {
        final List<WxMpProperties.MpConfig> configs = this.properties.getConfigs();

        if (configs == null) {
            throw new RuntimeException("大哥，拜托先看下项目首页的说明（readme文件），添加下相关配置，注意别配错了！");
        }
        WxMpService service = new WxMpServiceImpl();
        service.setMultiConfigStorages(configs
                .stream().map(a -> {
                    WxMpDefaultConfigImpl configStorage;
                    configStorage = new WxMpDefaultConfigImpl();

                    configStorage.setAppId(a.getAppId());
                    configStorage.setSecret(a.getSecretKey());
                    configStorage.setAesKey(a.getAccessKey());
                    configStorage.setToken(a.getToken());
                    return configStorage;
                }).collect(Collectors.toMap(WxMpDefaultConfigImpl::getAppId, a -> a, (o, n) -> o)));
        return service;
    }

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);
        // 记录所有事件的日志 （异步执行）
        newRouter.rule().handler(this.logHandler).next();
        // 关注事件
        newRouter.rule().async(false).msgType(EVENT).event(SUBSCRIBE).handler(this.subscribeHandler).end();
        // 扫码事件
        newRouter.rule().async(false).msgType(EVENT).event(EventType.SCAN).handler(this.scanHandler).end();
        // 默认
        newRouter.rule().async(false).handler(this.messageHandler).end();
        return newRouter;
    }

}
