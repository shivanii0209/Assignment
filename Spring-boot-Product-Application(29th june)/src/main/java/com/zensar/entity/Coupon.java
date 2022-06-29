package com.zensar.entity;


import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value= {@NamedQuery(name="Coupon.com" ,query="from Coupon c where c.couponCode=?1"),
@NamedQuery(name="Coupon.com1",query="from Coupon c where c.couponCode=?1 and c.couponId=?2")})
//@NamedQuery(name="Coupon.com" ,query="from Coupon c where c.couponCode=?1")
//@NamedQuery(name="Coupon.com1",query="from Coupon c where c.couponCode=?1 and c.couponId=?2")
@NamedNativeQuery(name="Coupon.com2",query="select * from Coupon c where c.coupon_code=?1 and c.coupon_id=?2 ",resultClass = Coupon.class)
public class Coupon {
	
	private int couponId;
	private String couponCode;
	private String expDate;
	private String couponName;
	private Double discount;
	
	
	public Coupon() {
		super();
	}
	public Coupon(int couponId, String couponCode, String expDate, String couponName, Double discount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expDate = expDate;
		this.couponName = couponName;
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
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", expDate=" + expDate + ", couponName="
				+ couponName + ", discount=" + discount + "]";
	}

	

}
