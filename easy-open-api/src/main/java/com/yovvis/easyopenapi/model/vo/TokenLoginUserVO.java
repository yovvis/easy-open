package com.yovvis.easyopenapi.model.vo;

import cn.dev33.satoken.stp.SaTokenInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * 已登录用户视图（脱敏）
 **/
@Data
public class TokenLoginUserVO implements Serializable {
    /**
     *token的信息
     */
    private transient SaTokenInfo saTokenInfo;

    private static final long serialVersionUID = 1L;
}
