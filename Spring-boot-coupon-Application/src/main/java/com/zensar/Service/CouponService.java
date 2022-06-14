package com.zensar.Service;

import java.util.List;

import com.zensar.entity.Coupon;

public interface CouponService {
	public Coupon getCoupon(int couponId);

	public List<Coupon> getAllCoupon();

	public void insertCoupon(Coupon coupon);

	public void updateCoupon(int couponId, Coupon coupon);

	public void deleteCoupon(int couponId);
}
