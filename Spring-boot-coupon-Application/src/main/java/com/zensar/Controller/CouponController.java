package com.zensar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Service.CouponServiceImpl;
import com.zensar.entity.Coupon;
@RestController
@RequestMapping("/coupon-api")
public class CouponController {
	@Autowired
	private CouponServiceImpl couponservice;

	@GetMapping(value = "/coupons/{couponId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Coupon getCoupon(@PathVariable("couponId") int couponId) {
		return couponservice.getCoupon(couponId);
	}

	@GetMapping(value = { "/coupons"}, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public List<Coupon> getAllCoupon() {
		return couponservice.getAllCoupon();
	}

	@PostMapping(value = "/coupons", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertCoupon(@RequestBody Coupon coupon) {
		couponservice.insertCoupon(coupon);

	}

	@PutMapping(value = "/coupons/{couponId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public void updateCoupon(@PathVariable("couponId") int couponId, @RequestBody Coupon coupon) {
		couponservice.updateCoupon(couponId, coupon);
	}

	
	@DeleteMapping(value = "/coupons/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponservice.deleteCoupon(couponId);

	}
}