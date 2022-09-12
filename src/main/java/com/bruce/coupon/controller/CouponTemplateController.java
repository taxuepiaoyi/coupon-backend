package com.bruce.coupon.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.bruce.coupon.domain.CouponTemplateHttpInfo;
import com.bruce.coupon.domain.PagedCouponTemplateHttpInfo;
import com.bruce.coupon.domain.query.TemplateHttpSearchParams;
import com.bruce.coupon.service.CouponTemplateHttpService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/template")
public class CouponTemplateController {

    @Autowired
    private CouponTemplateHttpService couponTemplateHttpService ;

    // 创建优惠券
    @PostMapping("/addTemplate")
    public CouponTemplateHttpInfo addTemplate(@Valid @RequestBody CouponTemplateHttpInfo request) {
        log.info("Create coupon template: data={}", request);
        return couponTemplateHttpService.createTemplate(request);
    }

    @PostMapping("/cloneTemplate")
    public CouponTemplateHttpInfo cloneTemplate(@RequestParam("id") Long templateId) {
        log.info("Clone coupon template: data={}", templateId);
        return couponTemplateHttpService.cloneTemplate(templateId);
    }

    // 读取优惠券
    @GetMapping("/getTemplate")
    @SentinelResource(value = "getTemplate" ,blockHandler = "getTemplateBlockHandler")
    public CouponTemplateHttpInfo getTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id={}", id);
        return couponTemplateHttpService.loadTemplateInfo(id);
    }


    /**
     * 读取优惠券的降级方法
     * @param id
     * @param exception
     * @return
     */
    public CouponTemplateHttpInfo getTemplateBlockHandler(Long id, BlockException exception){
        log.info("Load getTemplateBlockHandler, id={}", id);
        return null ;
    }


    // 批量获取
    @GetMapping("/getTemplateInBatch")
    @SentinelResource(value = "getTemplateInBatch" ,blockHandler = "getTemplateInBatchBlockHandler",fallback = "getTemplateInBatchFallBack")
    public Map<Long, CouponTemplateHttpInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids) {
        log.info("getTemplateInBatch: {}", JSON.toJSONString(ids));
        return couponTemplateHttpService.getTemplateInfoMap(ids);
    }

    //批量获取优惠券的降级处理
    private Map<Long,CouponTemplateHttpInfo> getTemplateInBatchBlockHandler(Collection<Long> ids, BlockException exception){
        log.info("getTemplateInBatchBlockHandler限流了");
        return Maps.newHashMap() ;
    }

    //批量获取优惠券的降级处理
    private Map<Long,CouponTemplateHttpInfo> getTemplateInBatchFallBack(Collection<Long> ids, BlockException exception){
        log.info("getTemplateInBatchFallBack....降级处理");
        return Maps.newHashMap() ;
    }

    // 搜索模板
    @PostMapping("/search")
    public PagedCouponTemplateHttpInfo search(@Valid @RequestBody TemplateHttpSearchParams request) {
        log.info("search templates, payload={}", request);
        return couponTemplateHttpService.search(request);
    }

    // 优惠券无效化
    @DeleteMapping("/deleteTemplate")
    public void deleteTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id={}", id);
        couponTemplateHttpService.deleteTemplate(id);
    }
}
