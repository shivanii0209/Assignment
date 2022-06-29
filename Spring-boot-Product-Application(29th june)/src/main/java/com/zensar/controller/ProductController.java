package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.client.RestTemplate;

import com.zensar.dto.CouponDto;
import com.zensar.dto.ProductDto;
import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.restclient.CouponRestClient;
import com.zensar.service.ProductServiceImpl;

import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping(value = "/Product-Api", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })

public class ProductController {

	@Autowired
	private ProductServiceImpl productservice;
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	@Autowired
	public CouponRestClient couponRestClient;

	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductDto>(productservice.getProduct(productId), HttpStatus.OK);
	}

	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "4") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "productName") String sortBy,
			@RequestParam(value = "Dir", required = false, defaultValue = "DESC") Direction Dir) {
		return new ResponseEntity<List<ProductDto>>(productservice.getAllProducts(pageNumber, pageSize, sortBy, Dir),
				HttpStatus.OK);
	}

	// "http://localhost:9090/coupon-api/coupons/couponcde/"
	@PostMapping(value = "/products")
	@Retry(name="productapi",fallbackMethod = "myFallBackMethod")
	public ProductDto insertProduct(@RequestBody ProductDto product) {
		
			System.out.println("Hi******************************************");
			/*
			 * ResponseEntity<Coupon> coupons = restTemplate.getForEntity(
			 * "http://COUPON-SERVICE/coupon-api/coupons/couponcde/" +
			 * product.getCouponCode(), Coupon.class); Coupon couponObj = coupons.getBody();
			 * (productDto.getCouponCode());
			 */
			CouponDto couponObj = couponRestClient.getCoupon(product.getCouponCode());
			System.out.println(couponObj);
			product.setProductPrice(product.getProductPrice() - couponObj.getDiscount());
		return productservice.insertProduct(product);
	}
	public ProductDto myFallBackMethod(Throwable t) {
		return new ProductDto();
	}

	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {
		productservice.updateProduct(productId, productDto);
		return new ResponseEntity<String>("Product Updated Successfully !!!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productservice.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted !!", HttpStatus.OK);
	}

	@GetMapping(value = "/products/getByProductName/{productName}")
	public ResponseEntity<List<ProductDto>> getByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productservice.getByProductName(productName), HttpStatus.OK);
	}

	@GetMapping(value = "/products/getByProdName/{productName}")
	public ResponseEntity<List<ProductDto>> getByProdName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productservice.getByProdName(productName), HttpStatus.OK);
	}

	@GetMapping(value = "/products/findByProductNameAndProductPrice/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> findByProductNameAndProductPrice(
			@PathVariable("productName") String productName, @PathVariable("productPrice") int productPrice) {
		return new ResponseEntity<List<ProductDto>>(
				productservice.findByProductNameAndProductPrice(productName, productPrice), HttpStatus.OK);
	}

	@GetMapping(value = "/products/findByProdNameAndProdPrice/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> findByProdNameAndProdPrice(@PathVariable String productName,
			@PathVariable int productPrice) {
		return new ResponseEntity<List<ProductDto>>(
				productservice.findByProdNameAndProdPrice(productName, productPrice), HttpStatus.OK);
	}

	@GetMapping(value = "/products/findByProdNameOrProdPrice/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> findByProdNameOrProdPrice(String productName, int productPrice) {
		return new ResponseEntity<List<ProductDto>>(productservice.findByProdNameOrProdPrice(productName, productPrice),
				HttpStatus.OK);
	}
}