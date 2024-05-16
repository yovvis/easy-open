package com.yovvis.easyopenapiservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yovvis.easyopenmodel.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.yovvis.easyopenmodel.entity.InterfaceInfo;
import com.yovvis.easyopenmodel.vo.InterfaceInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yovvis
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2024-04-25 22:56:45
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验数据
     *
     * @param interfaceInfo
     * @param add 对创建的数据进行校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 获取查询条件
     *
     * @param interfaceInfoQueryRequest
     * @return
     */
    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);

    /**
     * 获取接口封装
     *
     * @param interfaceInfo
     * @param request
     * @return
     */
    InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request);

    /**
     * 分页获取接口封装
     *
     * @param interfaceInfoPage
     * @param request
     * @return
     */
    Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request);
}