package com.yovvis.easyopenuserservice.model.dto.user;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 用户更新请求
 */
@Data
public class UserUpdateRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 新头像
     * 这主要是用来解决上传时，后端无法区分当前是否需要重新上传头像去替换原来的头像地址，
     * 只要这个属性有值，就说明需要重新上传，否则直接使用原来的地址入库就行，属于冗余值
     */
    private MultipartFile newAvatar;

    /**
     * 简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    private String userStatus;

    private static final long serialVersionUID = 1L;
}
