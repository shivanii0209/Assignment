package com.zensar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Service.CouponServiceImpl;
import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

@RestController
@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponController {
	@Autowired
	private CouponServiceImpl couponservice;

	@GetMapping(value = "/coupons/{couponId}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		return new ResponseEntity<CouponDto>(couponservice.getCoupon(couponId), HttpStatus.OK);
	}

	@GetMapping(value =  "/coupons" )
	public ResponseEntity<List<CouponDto>> getAllCoupon(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
		return new ResponseEntity<List<CouponDto>>(couponservice.getAllCoupon(pageNumber, pageSize), HttpStatus.OK);
	}

	@PostMapping(value = "/coupons")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		return new ResponseEntity<CouponDto>(couponservice.insertCoupon(couponDto), HttpStatus.CREATED);
	}

	@PutMapping(value = "/coupons/{couponId}")
	public ResponseEntity<String> updateCoupon(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		couponservice.updateCoupon(couponId, couponDto);
		return new ResponseEntity<String>("Student Updated Successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/coupons/{couponId}")
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int couponId) {
		couponservice.deleteCoupon(couponId);
		return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);

	}

	@GetMapping(value = "/coupons/couponcde/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCode(@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<List<CouponDto>>(couponservice.getByCouponCode(couponCode), HttpStatus.OK);
	}

	@GetMapping(value = "/coupons/{couponCode}/{couponId}")
	public ResponseEntity<List<CouponDto>> findByCouponCodeAndCouponId(@PathVariable String couponCode,
			@PathVariable int couponId) {
		return new ResponseEntity<List<CouponDto>>(couponservice.findByCouponCodeAndCouponId(couponCode, couponId),
				HttpStatus.OK);
	}

	@GetMapping(value = "/coupons/couponcode/{couponCode}")
	public List<Coupon> com(@PathVariable String couponCode) {
		return couponservice.com(couponCode);
	}

	@GetMapping(value = "/coupons/cou/{couponCode}/{couponId}")
	public List<Coupon> com1(@PathVariable String couponCode, @PathVariable int couponId) {
		return couponservice.com1(couponCode, couponId);
	}

	@GetMapping(value = "/coupons/cc/{couponCode}/{couponId}")
	public List<Coupon> com2(@PathVariable String couponCode, @PathVariable int couponId) {
		return couponservice.com2(couponCode, couponId);
	}

	@GetMapping(value = "/coupons/repo/{couponCode}/{couponId}")
	public List<Coupon> com3(@PathVariable String couponCode, @PathVariable int couponId) {
		return couponservice.com3(couponCode, couponId);
	}

}