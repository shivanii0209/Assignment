package com.zensar.dto;

public class CouponDto {
	private int couponId;
	private String couponCode;
	private String expDate;
	private Double discount;
	public CouponDto() {
		super();
	}
	public CouponDto(int couponId, String couponCode, String expDate, Double discount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expDate = expDate;
		this.discount = discount;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "CouponDto [couponId=" + couponId + ", couponCode=" + couponCode + ", expDate=" + expDate + ", discount="
				+ discount + "]";
	}
	
}
