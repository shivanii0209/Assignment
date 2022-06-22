package com.zensar.Controller;

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

import com.zensar.Dto.ProductDto;
import com.zensar.Entity.Product;
import com.zensar.Service.ProductServiceImpl;

@RestController
@RequestMapping(value = "/Product-Api", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })

public class ProductController {
	@Autowired
	private ProductServiceImpl productservice;

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

	@PostMapping(value = "/products")
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(productservice.insertProduct(productDto), HttpStatus.CREATED);
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
	public ResponseEntity< List<ProductDto>> getByProdName(@PathVariable("productName") String productName) {
		return  new ResponseEntity<List<ProductDto>>(productservice.getByProdName(productName),HttpStatus.OK);
	}

	@GetMapping(value = "/products/findByProductNameAndProductPrice/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> findByProductNameAndProductPrice(
			@PathVariable("productName") String productName, @PathVariable("productPrice") int productPrice) {
		return new ResponseEntity<List<ProductDto>>(
				productservice.findByProductNameAndProductPrice(productName, productPrice), HttpStatus.OK);
	}

	@GetMapping(value = "/products/findByProdNameAndProdPrice/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> findByProdNameAndProdPrice(@PathVariable String productName, @PathVariable int productPrice) {
		return new ResponseEntity<List<ProductDto>>(productservice.findByProdNameAndProdPrice(productName, productPrice),HttpStatus.OK);
	}

	@GetMapping(value = "/products/findByProdNameOrProdPrice/{productName}/{productPrice}")
	public ResponseEntity< List<ProductDto>> findByProdNameOrProdPrice(String productName, int productPrice) {
		return  new ResponseEntity<List<ProductDto>>(productservice.findByProdNameOrProdPrice(productName, productPrice),HttpStatus.OK);
	}
}