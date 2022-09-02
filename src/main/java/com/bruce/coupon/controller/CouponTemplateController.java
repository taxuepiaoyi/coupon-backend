package com.bruce.coupon.controller;

import com.alibaba.fastjson.JSON;
import com.bruce.coupon.domain.CouponTemplateHttpInfo;
import com.bruce.coupon.domain.PagedCouponTemplateHttpInfo;
import com.bruce.coupon.domain.query.TemplateHttpSearchParams;
import com.bruce.coupon.service.CouponTemplateHttpService;
import com.bruce.coupon.template.domain.CouponTemplateInfo;
import com.bruce.coupon.template.domain.PagedCouponTemplateInfo;
import com.bruce.coupon.template.domain.TemplateSearchParams;
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
    public CouponTemplateHttpInfo getTemplate(@RequestParam("id") Long id) {
        log.info("Load template, id={}", id);
        return couponTemplateHttpService.loadTemplateInfo(id);
    }

    // 批量获取
    @GetMapping("/getBatch")
    public Map<Long, CouponTemplateHttpInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids) {
        log.info("getTemplateInBatch: {}", JSON.toJSONString(ids));
        return couponTemplateHttpService.getTemplateInfoMap(ids);
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
