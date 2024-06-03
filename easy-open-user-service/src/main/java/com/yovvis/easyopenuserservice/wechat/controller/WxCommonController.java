package com.yovvis.easyopenuserservice.wechat.controller;

import cn.hutool.core.util.RandomUtil;
import com.yovvis.easyopencommon.common.BaseResponse;
import com.yovvis.easyopencommon.common.ResultUtils;
import com.yovvis.easyopenuserservice.wechat.constant.redis.LoginConst;
import com.yovvis.easyopenuserservice.wechat.domain.bo.QrcodeInfoBO;
import com.yovvis.easyopenuserservice.wechat.domain.vo.QrcodeGetVO;
import com.yovvis.easyopenuserservice.wechat.service.QrcodeService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;

import static com.yovvis.easyopenuserservice.wechat.constant.redis.LoginConst.LOGIN_EXPIRE_TIME;

/**
 * @Author Kkuil
 * @Date 2024/6/2 20:47
 * @Description 微信控制器
 */
@RestController
@RequestMapping("/wx/common")
public class WxCommonController {

    @Resource
    private QrcodeService qrcodeService;

    @Resource
    private WxMpService wxMpService;

    @GetMapping("/qrcode")
    public BaseResponse<QrcodeGetVO> getQrCode() throws WxErrorException {
        // 生成微信绑定的二维码
        Integer code = generateRandomCode();
        // 生成url
        String qrCodeUrl = generateQrCodeUrl(code);
        // 将state保存到数据库或缓存中
        QrcodeInfoBO qrcodeInfoBO = new QrcodeInfoBO(true);
        qrcodeService.saveLoginStatus(code, qrcodeInfoBO);
        // 返回
        QrcodeGetVO qrcodeGetVO = new QrcodeGetVO();
        qrcodeGetVO.setCode(code);
        qrcodeGetVO.setUrl(qrCodeUrl);
        return ResultUtils.success(qrcodeGetVO);
    }

    /**
     * 轮询接口
     *
     * @return 接口状态信息
     */
    @GetMapping("poll")
    public BaseResponse<QrcodeInfoBO> getQrcodeInfoBO(String code) {
        return ResultUtils.success(qrcodeService.getLoginStatus(Integer.valueOf(code)));
    }

    /**
     * 生成微信绑定的二维码的code
     *
     * @return
     */
    private Integer generateRandomCode() {
        return Integer.valueOf(RandomUtil.randomNumbers(5));
    }

    /**
     * 根据code生成URL
     *
     * @param code
     * @return
     */
    private String generateQrCodeUrl(Integer code) throws WxErrorException {
        // 获取登录二维码
        WxMpQrCodeTicket wxMpQrCodeTicket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(code, (int) LoginConst.LOGIN_EXPIRE_TIME.getSeconds());
        return wxMpQrCodeTicket.getUrl();
    }
}
