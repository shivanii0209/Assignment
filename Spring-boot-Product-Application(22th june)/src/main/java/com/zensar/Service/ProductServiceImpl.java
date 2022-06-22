package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.Dto.ProductDto;
import com.zensar.Entity.Product;
import com.zensar.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, String sortBy, Direction Dir) {
		List<ProductDto> ListOfProductDto = new ArrayList<ProductDto>();
		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize, Dir, sortBy));
		List<Product> content = findAll.getContent();
		for (Product product : content) {
			ListOfProductDto.add(modelMapper.map(product, ProductDto.class));
		}
		return ListOfProductDto;
	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product save = productRepository.save(product);
		return modelMapper.map(save, ProductDto.class);
	}

	@Override
	public void updateProduct(int productId, ProductDto productDto) {

		Product map = modelMapper.map(productDto, Product.class);
		productRepository.save(map);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public ProductDto getProduct(int productId) {
		Product product = productRepository.findById(productId).get();
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getByProductName(String productName) {
		List<ProductDto> productDtos=new ArrayList();
		List<Product> products =productRepository.findByProductName(productName);
		for(Product product:products) 
			productDtos.add(modelMapper.map(product, ProductDto.class));
			
		return productDtos;

	}

	@Override
	public List<ProductDto> getByProdName(String productName) {
		List<ProductDto> productDtos=new ArrayList();
		List<Product> products =productRepository.method1(productName);
		for(Product product:products) 
			productDtos.add(modelMapper.map(product, ProductDto.class));
			
		return productDtos;
		
		//return productRepository.method1(productName);
		//return productRepository.method4(productName);
		//return productRepository.method5(productName);

	}

	@Override
	public List<ProductDto> findByProductNameAndProductPrice(String productName, int productPrice) {
			List<ProductDto> productDtos=new ArrayList();
			List<Product> products =productRepository.findByProductNameAndProductPrice(productName, productPrice);
			for(Product product:products) 
				productDtos.add(modelMapper.map(product, ProductDto.class));
				
			return productDtos;

		
	}

	@Override
	public List<ProductDto> findByProdNameAndProdPrice(String productName, int productPrice) {
		List<ProductDto> productDtos=new ArrayList();
		List<Product> products =productRepository.findByProductNameAndProductPrice(productName, productPrice);
		for(Product product:products) 
			productDtos.add(modelMapper.map(product, ProductDto.class));
			
		return productDtos;
		//return productRepository.method2(productName, productPrice);
	}
	@Override
	public List<ProductDto> findByProdNameOrProdPrice(String productName, int productPrice) {
		List<ProductDto> productDtos=new ArrayList();
		List<Product> products =productRepository.findByProductNameAndProductPrice(productName, productPrice);
		for(Product product:products) 
			productDtos.add(modelMapper.map(product, ProductDto.class));
			
		return productDtos;
		//return productRepository.method3(productName, productPrice);
		//return productRepository.method6(productName, productPrice);
		
	}
}
