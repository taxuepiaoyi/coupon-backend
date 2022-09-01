package com.bruce.coupon.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 优惠券查询请求参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateHttpSearchParams {

    private Long id;

    private String name;

    private String type;

    private Long shopId;

    private Boolean available;

    private int page;

    private int pageSize;
}
