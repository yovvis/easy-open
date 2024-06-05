package com.yovvis.easyopenuserservice.wxmp.constant.redis;

import java.time.Duration;

/**
 * @Author Kkuil
 * @Date 2024/6/2 19:49
 * @Description 微信登录常量类
 */
public class LoginConst {

    public static final String LOGIN_PREFIX = "login:wx:%s";

    public static String getPrefix(String prefix) {
        return String.format(LOGIN_PREFIX, prefix);
    }

    /**
     * 登录有效期
     */
    public static final Duration LOGIN_EXPIRE_TIME = Duration.ofHours(1);

}
