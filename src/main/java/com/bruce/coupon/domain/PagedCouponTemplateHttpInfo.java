package com.bruce.coupon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 创建优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedCouponTemplateHttpInfo {
    public List<CouponTemplateHttpInfo> templates;

    public int page;

    public long total;
}
