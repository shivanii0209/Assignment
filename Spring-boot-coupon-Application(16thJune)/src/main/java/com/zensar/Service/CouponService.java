package com.zensar.Service;

import java.util.List;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

public interface CouponService {
	public CouponDto getCoupon(int couponId);

	public List<CouponDto> getAllCoupon(int pageNumber,int pageSize);

	public CouponDto insertCoupon(CouponDto couponDto);

	public void updateCoupon(int couponId, CouponDto couponDto);

	public void deleteCoupon(int couponId);

	List<CouponDto> getByCouponCode(String couponCode);
	List<CouponDto> findByCouponCodeAndCouponId(String couponCode,int couponId);
	List<Coupon> com(String couponCode);
	List<Coupon> com1(String couponCode,int couponId);
	List<Coupon> com2(String couponCode,int couponId);
	List<Coupon> com3(String couponCode,int couponId);
	
}
