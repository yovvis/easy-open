package com.yovvis.easyopenuserservice.wxmp.service;

import cn.hutool.core.util.ObjectUtil;
import com.yovvis.easyopenapi.model.entity.user.User;
import com.yovvis.easyopenuserservice.dao.UserDAO;
import com.yovvis.easyopenuserservice.service.UserService;
import com.yovvis.easyopenuserservice.wxmp.adapter.UserAdapter;
import com.yovvis.easyopenuserservice.wxmp.adapter.WechatTextBuilderAdapter;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Kkuil
 * @Date 2023/9/24
 * @Description 处理与微信api的交互逻辑
 */
@Slf4j
@Service
public class WxMessageService {
    /**
     * 用户的openId和前端登录场景code的映射关系
     */
    private static final ConcurrentHashMap<String, Integer> OPENID_EVENT_CODE_MAP = new ConcurrentHashMap<>();

    /**
     * 重定向URL
     */
    private static final String URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

    /**
     * 给用户发送的授权消息
     */
    public static final String SKIP_URL_SCHEMA = "点击链接授权：<a href=\"%s\">登录</a>";

    @Value("${wx.mp.callback}")
    private String callback;

    @Value("${server.servlet.context-path}")
    private String prefix = "/api/user";

    @Resource
    private UserDAO userDao;

    @Resource
    private UserService userService;

    /**
     * 扫码 (能触发这个事件的前提都是建立在已经关注公众号的基础上，千万别踩坑)
     *
     * @param wxMpXmlMessage 微信xml消息
     * @return 返回消息
     */
    public WxMpXmlOutMessage scan(WxMpService wxMpService, WxMpXmlMessage wxMpXmlMessage) {
        // 获取扫码用户的openid
        String openId = wxMpXmlMessage.getFromUser();
        Integer code = Integer.parseInt(replacePrefixIfPresent(wxMpXmlMessage));
        // 判断是否已经注册，且授权成功了（名字头像等信息已经获取到了）
        // 判断用户是否注册过
        User user = userDao.getByOpenId(openId);
        // TODO 1. 授权了，直接登录
        if (!ObjectUtil.isNull(user)) {
            userService.loginByWx(code, user);
            return new WechatTextBuilderAdapter().build("登录成功，已上线", wxMpXmlMessage);
        }
        // TODO 2. 未授权，让用户授权
        return this.publishAuthorizeUrl(wxMpService, wxMpXmlMessage);
    }

    /**
     * 订阅即登录
     *
     * @param wxMpService    微信消息
     * @param wxMpXmlMessage 微信xml消息
     * @return 返回消息
     */
    public WxMpXmlOutMessage subscribe(WxMpService wxMpService, WxMpXmlMessage wxMpXmlMessage) {
        // 获取到当前用户的openid
        String openId = wxMpXmlMessage.getFromUser();
        Integer code = Integer.parseInt(replacePrefixIfPresent(wxMpXmlMessage));
        // 判断用户是否注册过
        User user = userDao.getByOpenId(openId);
        if (!ObjectUtil.isNull(user)) {
            // TODO 这里主要是为了防止已经授权登录的用户，又取消订阅了我们的公众号，
            // TODO 然后他又重新关注了我们的公众号，我们只要给她登录就行了，不用给他发授权链接
            // 登录
            userService.loginByWx(code, user);
        } else {
            // 存储openId和code的映射关系，不然后面，用户点击授权我们没办法获取到code
            OPENID_EVENT_CODE_MAP.put(openId, code);
            // 这里给用户发布授权链接，让用户点击授权，我们才能获取到用户的信息
            return this.publishAuthorizeUrl(wxMpService, wxMpXmlMessage);
        }
        return new WechatTextBuilderAdapter().build("感谢关注，", wxMpXmlMessage);
    }

    /**
     * 发布授权信息
     *
     * @param wxMpService
     * @param wxMpXmlMessage
     * @return
     */
    public WxMpXmlOutMessage publishAuthorizeUrl(WxMpService wxMpService, WxMpXmlMessage wxMpXmlMessage) {
        String url = String.format(URL, wxMpService.getWxMpConfigStorage().getAppId(), URLEncoder.encode(callback + prefix + "/wx/portal/public/callBack"));
        String format = String.format(SKIP_URL_SCHEMA, url);
        return new WechatTextBuilderAdapter().build(format, wxMpXmlMessage);
    }

    /**
     * 只有当用户点击授权链接，我们才可以获取到用户的完整信息，然后进行保存
     *
     * @param userInfo 用户信息
     */
    public void authorize(WxOAuth2UserInfo userInfo) {
        // 判断该用户是否已经注册过
        User userInDB = userDao.getByOpenId(userInfo.getOpenid());
        Integer code = OPENID_EVENT_CODE_MAP.get(userInfo.getOpenid());
        // 直接登录
        if (userInDB != null) {
            userService.loginByWx(code, userInDB);
        } else {
            // 注册
            // 保存用户信息
            User user = UserAdapter.buildAuthorizeUser(userInfo);
            // 更具openId获取code
            userService.registerByWx(code, user);
        }
    }

    /**
     * 去除事件前缀
     *
     * @param wxMpXmlMessage 微信对象
     * @return 事件Key
     */
    private String replacePrefixIfPresent(WxMpXmlMessage wxMpXmlMessage) {
        // 扫码关注的渠道事件有前缀，需要去除
        return wxMpXmlMessage.getEventKey().replace("qrscene_", "");
    }
}
