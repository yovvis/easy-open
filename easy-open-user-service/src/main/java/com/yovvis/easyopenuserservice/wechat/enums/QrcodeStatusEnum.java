package com.yovvis.easyopenuserservice.wechat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Kkuil
 * @Date 2024/6/2 20:32
 * @Description 微信二维码状态枚举
 */
@Getter
@AllArgsConstructor
public enum QrcodeStatusEnum {
    /**
     *
     */
    UN_SCAN(10005, "未扫码"),
    SCANNED(10006, "扫码成功，等待订阅"),
    SUBSCRIBE(10007, "订阅工程，等待授权"),
    AUTHORIZED(10008, "授权成功"),
    ;

    public final int code;
    public final String desc;

}
