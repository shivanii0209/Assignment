package com.zensar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.Repository.CouponRepository;
import com.zensar.entity.Coupon;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponrepository;
	
	@Override
	public Coupon getCoupon(int couponId) {
		return couponrepository.findById(couponId).get();
	}

	@Override
	public List<Coupon> getAllCoupon() {
		return couponrepository.findAll();
	}

	@Override
	public void insertCoupon(Coupon coupon) {
		couponrepository.save(coupon);
	}

	@Override
	public void updateCoupon(int couponId, Coupon coupon) {
		couponrepository.save(coupon);		
	}

	@Override
	public void deleteCoupon(int couponId) {
		couponrepository.deleteById(couponId);		
	}

}
