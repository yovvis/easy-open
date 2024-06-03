package com.yovvis.easyopenuserservice.wechat.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.hutool.json.JSONUtil;
import com.yovvis.easyopenuserservice.wechat.constant.redis.LoginConst;
import com.yovvis.easyopenuserservice.wechat.domain.bo.QrcodeInfoBO;
import io.swagger.models.auth.In;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author Kkuil
 * @Date 2024/6/2 20:26
 * @Description 微信二维码业务类
 */
@Service
public class QrcodeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 保存二维码的状态信息
     *
     * @param code         微信二维码绑定的code
     * @param qrcodeInfoBO 二维码状态信息
     */
    public void saveLoginStatus(Integer code, QrcodeInfoBO qrcodeInfoBO) {
        String prefix = LoginConst.getPrefix(String.valueOf(code));
        SaTokenInfo saTokenInfo = qrcodeInfoBO.getTokenLoginUserVO().getSaTokenInfo();
        String json = Optional.ofNullable(saTokenInfo)
                .map(JSONUtil::toJsonStr)
                .orElse("{}");
        stringRedisTemplate.opsForValue().set(prefix, json, LoginConst.LOGIN_EXPIRE_TIME.getSeconds(), TimeUnit.SECONDS);
    }

    /**
     * 获取二维码的状态信息
     *
     * @param code 微信二维码绑定的code
     */
    public QrcodeInfoBO getLoginStatus(Integer code) {
        String prefix = LoginConst.getPrefix(String.valueOf(code));
        String json = stringRedisTemplate.opsForValue().get(prefix);
        String bean = Optional.ofNullable(json)
                .orElse("{}");
        return JSONUtil.toBean(bean, QrcodeInfoBO.class);
    }
}
