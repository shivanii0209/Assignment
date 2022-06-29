package com.zensar.dto;

import javax.persistence.Transient;

public class ProductDto {
	private int productId;
	private String productName;
	private Double productPrice;
	private String productDescription;
	@Transient
	private String couponCode;
	
	
	public ProductDto() {
		super();
	}
	
	
	
	public ProductDto(int productId, String productName, Double productPrice, String productDescription,
			String couponCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.couponCode = couponCode;
	}

	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", couponCode=" + couponCode + "]";
	}

}