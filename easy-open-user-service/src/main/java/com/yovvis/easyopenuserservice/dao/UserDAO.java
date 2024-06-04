package com.yovvis.easyopenuserservice.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yovvis.easyopenapi.model.entity.user.User;
import com.yovvis.easyopenuserservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @Author Kkuil
 * @Date 2024/6/2 19:03
 * @Description 用户DAO
 */
@Service
public class UserDAO extends ServiceImpl<UserMapper, User> {

    /**
     * 通过微信的openid查询用户
     *
     * @param openId openid
     * @return 用户对象
     */
    public User getByOpenId(String openId) {
        return this.lambdaQuery()
                .eq(User::getOpenId, openId)
                .one();
    }

}
