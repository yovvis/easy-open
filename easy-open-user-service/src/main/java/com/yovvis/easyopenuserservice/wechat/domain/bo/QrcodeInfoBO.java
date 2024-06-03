package com.yovvis.easyopenuserservice.wechat.domain.bo;

import com.yovvis.easyopenapi.model.vo.TokenLoginUserVO;
import com.yovvis.easyopenuserservice.wechat.enums.QrcodeStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Kkuil
 * @Date 2024/6/2 19:44
 * @Description 微信二维码信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrcodeInfoBO {

    /**
     * 当前二维码状态信息
     */
    private Integer status;

    /**
     * 信息
     */
    private TokenLoginUserVO tokenLoginUserVO;

    public QrcodeInfoBO(boolean isGetCode) {
        this.status = QrcodeStatusEnum.UN_SCAN.getCode();
        this.tokenLoginUserVO = new TokenLoginUserVO();
    }

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", tokenLoginUserVO=" + tokenLoginUserVO +
                '}';
    }
}
