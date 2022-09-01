package com.bruce.coupon.service.impl;

import com.bruce.coupon.domain.CouponTemplateHttpInfo;
import com.bruce.coupon.domain.PagedCouponTemplateHttpInfo;
import com.bruce.coupon.domain.query.TemplateHttpSearchParams;
import com.bruce.coupon.service.CouponTemplateHttpService;
import com.bruce.coupon.template.domain.CouponTemplateInfo;
import com.bruce.coupon.template.service.CouponTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Service
public class CouponTemplateHttpServiceImpl implements CouponTemplateHttpService {

    @DubboReference(check = false)
    private CouponTemplateService CouponTemplateService ;

    @Override
    public CouponTemplateHttpInfo createTemplate(CouponTemplateHttpInfo request) {
        CouponTemplateInfo requestTemplateInfo = CouponTemplateInfo.builder().build();
        CouponTemplateHttpInfo responseTemplateHttpInfo = CouponTemplateHttpInfo.builder().build() ;
        BeanUtils.copyProperties(request,requestTemplateInfo);
        BeanUtils.copyProperties(this.CouponTemplateService.createTemplate(requestTemplateInfo),responseTemplateHttpInfo);
        return responseTemplateHttpInfo;
    }

    @Override
    public CouponTemplateHttpInfo cloneTemplate(Long templateId) {
        CouponTemplateHttpInfo httpInfo = CouponTemplateHttpInfo.builder().build() ;
        BeanUtils.copyProperties(this.CouponTemplateService.cloneTemplate(templateId),httpInfo);
        return httpInfo;
    }

    @Override
    public PagedCouponTemplateHttpInfo search(TemplateHttpSearchParams request) {
        return null;
    }

    @Override
    public CouponTemplateHttpInfo loadTemplateInfo(Long id) {
        return null;
    }

    @Override
    public void deleteTemplate(Long id) {
        this.CouponTemplateService.deleteTemplate(id);
    }

    @Override
    public Map<Long, CouponTemplateHttpInfo> getTemplateInfoMap(Collection<Long> ids) {
        return null;
    }
}
