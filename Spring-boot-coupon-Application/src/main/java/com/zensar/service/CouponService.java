package com.zensar.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

public interface CouponService {
	public CouponDto getCoupon(int couponId);
	public CouponDto getCouponCode(int couponId);

	public List<CouponDto> getAllCoupon(int pageNumber,int pageSize,String sortingBy,Direction direction);

	public CouponDto insertCoupon(CouponDto couponDto);

	public CouponDto updateCoupon(int couponId, CouponDto couponDto);

	public void deleteCoupon(int couponId);

	CouponDto getByCouponCode(String couponCode);
	List<CouponDto> findByCouponCodeAndCouponId(String couponCode,int couponId);
	Coupon com(String couponCode);
	List<Coupon> com1(String couponCode,int couponId);
	List<Coupon> com2(String couponCode,int couponId);
	List<Coupon> com3(String couponCode,int couponId);
	
}
