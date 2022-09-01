package com.bruce.coupon.service;


import com.bruce.coupon.domain.CouponTemplateHttpInfo;
import com.bruce.coupon.domain.PagedCouponTemplateHttpInfo;
import com.bruce.coupon.domain.query.TemplateHttpSearchParams;

import java.util.Collection;
import java.util.Map;

public interface CouponTemplateHttpService {
    // 创建优惠券模板
    CouponTemplateHttpInfo createTemplate(CouponTemplateHttpInfo request);

    CouponTemplateHttpInfo cloneTemplate(Long templateId);

    // 模板查询（分页）
    PagedCouponTemplateHttpInfo search(TemplateHttpSearchParams request);

    // 通过模板ID查询优惠券模板
    CouponTemplateHttpInfo loadTemplateInfo(Long id);

    // 让优惠券模板无效
    void deleteTemplate(Long id);

    // 批量查询
    // Map是模板ID，key是模板详情
    Map<Long, CouponTemplateHttpInfo> getTemplateInfoMap(Collection<Long> ids);

}
