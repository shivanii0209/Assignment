package com.zensar.beans;

public class Product {
	private int productId;
	private String productName;
	private int productCost;
	public Product() {
		super();
		System.out.println("Hi default constructor");
	}
	
	public Product(int productId, String productName, int productCost) {
		super();
		System.out.println("Constructor Injection is called");
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		System.out.println("HI... I am Product Id set()method ");
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ "]";
	}
	
	

}
