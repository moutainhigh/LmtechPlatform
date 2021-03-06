package com.lmtech.infrastructure.facade.stub;

import com.lmtech.facade.request.NormalRequest;
import com.lmtech.facade.request.StringRequest;
import com.lmtech.facade.response.NormalResponse;
import com.lmtech.facade.response.StringResponse;
import com.lmtech.infrastructure.facade.response.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 租户服务入口
 */
@FeignClient(name = "lmtech-infrastructure")
@RequestMapping(value = "/tenancy")
public interface TenancyFacade {
    /**
     * 获取租户
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTenancy", method = RequestMethod.POST)
    TenancyResponse getTenancy(@RequestBody StringRequest request);

    /**
     * 通过唯一code码获取租户
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTenancyByCode", method = RequestMethod.POST)
    TenancyResponse getTenancyByCode(@RequestBody StringRequest request);

    @RequestMapping(value = "/getTenancyList", method = RequestMethod.POST)
    TenancyListResponse getTenancyList(TenancyQueryRequest request);

    /**
     * 获取租户分页数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTenancyOfPage", method = RequestMethod.POST)
    TenancyPageResponse getTenancyOfPage(@RequestBody TenancyPageRequest request);

    /**
     * 添加租户
     * @param request
     * @return
     */
    @RequestMapping(value = "/addTenancy", method = RequestMethod.POST)
    StringResponse addTenancy(@RequestBody TenancyRequest request);

    /**
     * 编辑租户
     * @param request
     * @return
     */
    @RequestMapping(value = "/editTenancy", method = RequestMethod.POST)
    NormalResponse editTenancy(@RequestBody TenancyRequest request);

    /**
     * 删除租户
     * @param request
     * @return
     */
    @RequestMapping(value = "/removeTenancy", method = RequestMethod.POST)
    NormalResponse removeTenancy(@RequestBody StringRequest request);

    /**
     * 开始营业
     * @param request
     */
    @RequestMapping(value = "/activeTenancy", method = RequestMethod.POST)
    NormalResponse activeTenancy(@RequestBody StringRequest request);

    /**
     * 停止营业
     * @param request
     */
    @RequestMapping(value = "/disableTenancy", method = RequestMethod.POST)
    NormalResponse disableTenancy(@RequestBody StringRequest request);
}
