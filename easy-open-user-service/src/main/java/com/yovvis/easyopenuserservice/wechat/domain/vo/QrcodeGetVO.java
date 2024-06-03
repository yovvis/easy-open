package com.yovvis.easyopenuserservice.wechat.domain.vo;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2024/6/2 20:55
 * @Description 获取二维码接口
 */
@Data
public class QrcodeGetVO {
    /**
     * 二维码绑定的code，可以用来识别是哪个二维码
     */
    private Integer code;

    /**
     * 二维码图片的URL，开发者可根据该URL自行生成需要的二维码图片
     */
    private String url;

}
