package com.zensar.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.dto.ProductDto;
import com.zensar.entity.Product;

public interface ProductService {
	public ProductDto getProduct(int productId);

	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, String sortBy, Direction Dir);

	public ProductDto insertProduct(ProductDto product);

	public void updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);

	public List<ProductDto> getByProductName(String productName);

	List<ProductDto> findByProductNameAndProductPrice(String productName, int productPrice);

	List<ProductDto> findByProdNameAndProdPrice(String productName, int productPrice);

	List<ProductDto> findByProdNameOrProdPrice(String productName, int productPrice);

	public List<ProductDto> getByProdName(String productName);

}
