package com.yovvis.easyopenuserservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yovvis.easyopenapi.model.entity.user.User;
import com.yovvis.easyopenapi.model.vo.LoginUserVO;
import com.yovvis.easyopenapi.model.vo.TokenLoginUserVO;
import com.yovvis.easyopenapi.model.vo.UserVO;
import com.yovvis.easyopenuserservice.model.dto.user.UserQueryRequest;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @return 脱敏后的用户信息
     */
    TokenLoginUserVO userLogin(String userAccount, String userPassword);

    /**
     * 用户登录（微信开放平台）
     *
     * @param wxOAuth2UserInfo 从微信获取的用户信息
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLoginByMpOpen(WxOAuth2UserInfo wxOAuth2UserInfo);

    /**
     * 获取当前登录用户
     *
     * @return
     */
    User getLoginUser();

    /**
     * 获取当前登录用户
     *
     * @return
     */
    User getLoginUser(String token);

    /**
     * 获取token用户
     *
     * @return
     */
    TokenLoginUserVO getTokenLoginUserVO(User user);

    /**
     * 获取当前登录用户（允许未登录）
     *
     * @return
     */
    User getLoginUserPermitNull();

    /**
     * 是否为管理员
     *
     * @return
     */
    boolean isAdmin();

    /**
     * 是否为管理员
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * 用户注销
     *
     * @return
     */
    boolean userLogout();

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取脱敏的用户信息
     *
     * @param user
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏的用户信息
     *
     * @param userList
     * @return
     */
    List<UserVO> getUserVO(List<User> userList);

    /**
     * 获取查询条件
     *
     * @param userQueryRequest
     * @return
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 使用微信登录
     *
     * @param code 微信二维码绑定的code
     * @param user 用户信息
     */
    void loginByWx(Integer code, User user);

    /**
     * 使用微信注册
     *
     * @param code 微信二维码绑定的code
     * @param user 需要保存的用户信息
     */
    void registerByWx(Integer code, User user);
}
