package com.yovvis.easyopenuserservice.wxmp.adapter;

import cn.hutool.core.util.RandomUtil;
import com.yovvis.easyopenapi.model.entity.User;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;

/**
 * @Author Kkuil
 * @Date 2023/9/26 20:37
 * @Description 用户适配器
 */
public class UserAdapter {

    public static final int MAX_NAME_LEN = 10;

    /**
     * 构建已授权的用户对象
     *
     * @param userInfo 用户信息
     * @return 用户信息
     */
    public static User buildAuthorizeUser(WxOAuth2UserInfo userInfo) {
        User user = new User();
        user.setMpOpenId(userInfo.getOpenid());
        user.setUserAvatar(userInfo.getHeadImgUrl());
        user.setGender(userInfo.getSex());
        if (userInfo.getNickname().length() > MAX_NAME_LEN) {
            user.setUserName("名字过长_" + RandomUtil.randomInt(100000));
        } else {
            user.setUserName(userInfo.getNickname());
        }
        return user;
    }
}
