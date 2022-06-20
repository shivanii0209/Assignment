package com.zensar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	@Query("from Coupon c  where c.couponCode=code or c.couponId=idd")
	List<Coupon> com3(@Param("code") String couponCode,@Param("idd") int couponId);
	//List<Coupon> getByCouponCode(String couponCode);
	//List<Coupon> findByCouponCode(String couponCode);
	//List<Coupon> findByCouponCodeAndCouponId(String couponCode,int couponId);
	List<Coupon> com(String couponCode);
	List<Coupon> com1(String couponCode,int couponId);
	List<Coupon> com2(String couponCode,int couponId);



}
