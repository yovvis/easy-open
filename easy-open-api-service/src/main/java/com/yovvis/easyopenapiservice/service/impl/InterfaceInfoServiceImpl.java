package com.yovvis.easyopenapiservice.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yovvis.easyopenapiservice.mapper.InterfaceInfoMapper;
import com.yovvis.easyopenapiservice.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.yovvis.easyopenapiservice.model.entity.InterfaceInfo;
import com.yovvis.easyopenapiservice.model.vo.InterfaceInfoVO;
import com.yovvis.easyopenapiservice.service.InterfaceInfoService;
import com.yovvis.easyopencommon.common.ErrorCode;
import com.yovvis.easyopencommon.constant.CommonConstant;
import com.yovvis.easyopencommon.exception.BusinessException;
import com.yovvis.easyopencommon.exception.ThrowUtils;
import com.yovvis.easyopencommon.utils.SqlUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yovvis
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2024-04-25 22:56:45
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    /**
     * 校验数据
     *
     * @param interfaceInfo
     * @param add 对创建的数据进行校验
     */
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        ThrowUtils.throwIf(interfaceInfo == null, ErrorCode.PARAMS_ERROR);
        // todo 从对象中取值
        String title = interfaceInfo.getName();
        // 创建数据时，参数不能为空
        if (add) {
            // todo 补充校验规则
            ThrowUtils.throwIf(StrUtil.isBlank(title), ErrorCode.PARAMS_ERROR);
        }
        // 修改数据时，有参数则校验
        // todo 补充校验规则
        if (StrUtil.isNotBlank(title)) {
            ThrowUtils.throwIf(title.length() > 80, ErrorCode.PARAMS_ERROR, "标题过长");
        }
    }

    /**
     * 获取查询条件
     *
     * @param interfaceInfoQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        if (interfaceInfoQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        Long id = interfaceInfoQueryRequest.getId();
        Long userId = interfaceInfoQueryRequest.getUserId();
        String name = interfaceInfoQueryRequest.getName();
        String description = interfaceInfoQueryRequest.getDescription();
        String url = interfaceInfoQueryRequest.getUrl();
        String requestHeader = interfaceInfoQueryRequest.getRequestHeader();
        String responseHeader = interfaceInfoQueryRequest.getResponseHeader();
        Integer status = interfaceInfoQueryRequest.getStatus();
        String method = interfaceInfoQueryRequest.getMethod();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        queryWrapper.eq(status != null, "status", status);
        queryWrapper.eq(userId != null, "userId", userId);
        queryWrapper.eq(StrUtil.isNotBlank(method), "method", method);
        queryWrapper.like(StrUtil.isNotBlank(name), "name", name);
        queryWrapper.like(StrUtil.isNotBlank(url), "url", url);
        queryWrapper.like(StrUtil.isNotBlank(description), "description", description);
        queryWrapper.like(StrUtil.isNotBlank(responseHeader), "responseHeader", responseHeader);
        queryWrapper.like(StrUtil.isNotBlank(requestHeader), "requestHeader", requestHeader);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    /**
     * 获取接口封装
     *
     * @param interfaceInfo
     * @param request
     * @return
     */
    @Override
    public InterfaceInfoVO getInterfaceInfoVO(InterfaceInfo interfaceInfo, HttpServletRequest request) {
        // 对象转封装类
        InterfaceInfoVO interfaceInfoVO = InterfaceInfoVO.objToVo(interfaceInfo);

        return interfaceInfoVO;
    }

    /**
     * 分页获取接口封装
     *
     * @param interfaceInfoPage
     * @param request
     * @return
     */
    @Override
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage,
        HttpServletRequest request) {
        List<InterfaceInfo> interfaceInfoList = interfaceInfoPage.getRecords();
        Page<InterfaceInfoVO> interfaceInfoVOPage =
            new Page<>(interfaceInfoPage.getCurrent(), interfaceInfoPage.getSize(), interfaceInfoPage.getTotal());
        if (CollUtil.isEmpty(interfaceInfoList)) {
            return interfaceInfoVOPage;
        }
        // 对象列表 => 封装对象列表
        List<InterfaceInfoVO> interfaceInfoVOList = interfaceInfoList.stream().map(interfaceInfo -> {
            return InterfaceInfoVO.objToVo(interfaceInfo);
        }).collect(Collectors.toList());
        interfaceInfoVOPage.setRecords(interfaceInfoVOList);
        return interfaceInfoVOPage;
    }
    // endregion

}
