package com.zensar.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponRestClient {

	
	@GetMapping(value ="coupon-api/coupons/couponcde/{couponCode}",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	CouponDto getCoupon(@PathVariable ("couponCode") String couponCode);

}
