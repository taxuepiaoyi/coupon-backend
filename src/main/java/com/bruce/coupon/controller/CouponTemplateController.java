package com.bruce.coupon.controller;

import com.bruce.coupon.domain.CouponTemplateHttpInfo;
import com.bruce.coupon.service.CouponTemplateHttpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
