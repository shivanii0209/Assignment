package com.zensar.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zensar.exception.EmptyProductList;
import com.zensar.exception.ProductNotFound;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<String> productNotFound(ProductNotFound exception) {
		return new ResponseEntity<String>("Product is not available, please check again your Database",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyProductList.class)
	public ResponseEntity<String> emptyProductList(EmptyProductList exception) {
		return new ResponseEntity<String>("Empty Product List", HttpStatus.BAD_REQUEST);
	}

}
