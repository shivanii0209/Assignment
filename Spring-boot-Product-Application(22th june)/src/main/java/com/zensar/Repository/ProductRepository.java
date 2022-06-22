package com.zensar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.Dto.ProductDto;
import com.zensar.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "from Product p where p.productName =?1",nativeQuery = false)
	public List<Product> method5(String productName);
	
	@Query(value = "select * from Product p where p.product_name =?1 or p.product_price",nativeQuery = true)
	public List<Product> method6(String productName,int productPrice);

	public List<Product> findByProductName(String productName);

	List<Product> findByProductNameAndProductPrice(String productName, int productPrice);

	List<Product> method1(String productName);

	List<Product> method4(String productName);

	List<Product> method2(String productName, int productPrice);

	List<Product> method3(String productName, int productPrice);

}
