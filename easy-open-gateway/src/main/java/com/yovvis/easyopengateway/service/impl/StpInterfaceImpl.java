package com.yovvis.easyopengateway.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 *
 * @author yovvis
 * @date 2024/5/28
 */
@Component
public class StpInterfaceImpl implements StpInterface {


    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // todo 返回此 loginId 拥有的权限列表
        List<String> list = new ArrayList<>();
        list.add("101");
        list.add("user.add");
        list.add("user.update");
        list.add("user.get");
        list.add("user.delete");
        list.add("art.*");
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

//        SaSession tokenSession = StpUtil.getTokenSession();
//        // 先判断是否已登录
//        Object userObj = tokenSession.get(USER_LOGIN_STATE);
//        User currentUser = (User) userObj;
//        if (currentUser == null || currentUser.getId() == null) {
//            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
//        }
//        //TODO 后面使用Redis来改造 从数据库查询（追求性能的话可以注释，直接走缓存）
        List<String> list = new ArrayList<>();
//        list.add(currentUser.getUserRole());
        return list;
    }

}