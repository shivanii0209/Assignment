package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

//@Table(name="My_Product")
/*
 * @NamedQuery(name="Product.method1",
 * query="from Product p where p.productName=?1")
 * 
 * @NamedQuery(name="Product.method2",query
 * ="from Product p where p.productName=?1 and p.productPrice=?2")
 */
@NamedQuery(name = "Product.method3", query = "from Product p where p.productName=?1 or p.productPrice=?2")
@NamedQueries(value = { @NamedQuery(name = "Product.method1", query = "from Product p where p.productName=?1"),
		@NamedQuery(name = "Product.method2", query = "from Product p where p.productName=?1 and p.productPrice=?2") })
@NamedNativeQuery(name = "Product.method4", query = "select * from Product where p.product_name=?1 ")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private Double productPrice;
	private String productDescription;
	@Transient
	private String couponCode;

	public Product() {
		super();
	}

	public Product(int productId, String productName, Double productPrice, String productDescription,
			String couponCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.couponCode = couponCode;
	}
	

	public Product(String productName, Double productPrice, String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

	public Product(int productId, String productName, Double productPrice, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

	public Product(String productName, Double productPrice, String productDescription, String couponCode) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
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

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", couponCode=" + couponCode + "]";
	}

}
