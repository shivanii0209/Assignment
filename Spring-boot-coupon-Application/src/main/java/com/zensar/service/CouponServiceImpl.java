package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;
import com.zensar.exception.CouponNotFound;
import com.zensar.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponrepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CouponDto getCoupon(int couponId) {
		if(!couponrepository.findById(couponId).isPresent())
			throw new CouponNotFound();
		Coupon coupon = couponrepository.findById(couponId).get();

		return modelMapper.map(coupon, CouponDto.class);
		// CouponDto dto= mapToDto(coupon);
		// return dto;
		/*
		 * CouponDto dto = new CouponDto(); dto.setCouponId(coupon.getCouponId());
		 * dto.setCouponCode(coupon.getCouponCode());
		 * dto.setExpDate(coupon.getexpDate()); return dto;
		 */
	}
	public CouponDto getCouponCode(int couponCode) {
		Coupon coupon = couponrepository.findById(couponCode).get();

		return modelMapper.map(coupon, CouponDto.class);

	}
	@Override
	public List<CouponDto> getAllCoupon(int pageNumber,int pageSize,String sortingBy,Direction direction) {
		//List<Coupon> listOfCoupons = couponrepository.findAll();
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
//		Page<Coupon> findAll=couponrepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"coudonCode")));
//		Page<Coupon> findAll=couponrepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.DESC,"coudonCode"));
		Page<Coupon> findAll=couponrepository.findAll(PageRequest.of(pageNumber,pageSize,direction,sortingBy));
		List<Coupon> content=findAll.getContent();
		for (Coupon coupon : content) {
			//listOfDto.add(mapToDto(coupon));
			listOfDto.add(modelMapper.map(coupon, CouponDto.class));
		}

		return listOfDto;
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
		//Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon insertedCoupon = couponrepository.save(coupon);
		return modelMapper.map(insertedCoupon,CouponDto.class);
		//CouponDto mapToDto = mapToDto(insertedCoupon);
		//return mapToDto;
		/*
		 * CouponDto dto = new CouponDto();
		 * dto.setCouponId(insertedCoupon.getCouponId());
		 * dto.setCouponCode(insertedCoupon.getCouponCode());
		 * dto.setExpDate(insertedCoupon.getexpDate()); return dto;
		 */

		/*
		 * CouponDto dto = new CouponDto(); dto.setCouponId(insertCoupon.getCouponId());
		 * dto.setCouponCode(insertCoupon.getCouponCode());
		 * dto.setExpDate(insertCoupon.getexpDate()); return dto;
		 */
	}

	@Override
	public CouponDto updateCoupon(int couponId, CouponDto couponDto) {
		if(!couponrepository.findById(couponId).isPresent())
			throw new CouponNotFound();
		//Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon coupon2 = couponrepository.save(coupon);
		 return modelMapper.map(coupon2,CouponDto.class);

		/*
		 * Coupon coupon = new Coupon(); coupon.setCouponId(couponDto.getCouponId());
		 * coupon.setCouponCode(couponDto.getCouponCode());
		 * coupon.setexpDate(couponDto.getExpDate());
		 * 
		 * couponrepository.save(coupon);
		 */
	}

	@Override
	public void deleteCoupon(int couponId) {
		couponrepository.deleteById(couponId);
	}
	/*
	 * public CouponDto mapToDto(Coupon coupon) { CouponDto dto = new CouponDto();
	 * dto.setCouponId(coupon.getCouponId());
	 * dto.setCouponCode(coupon.getCouponCode());
	 * dto.setExpDate(coupon.getexpDate()); return dto;
	 * 
	 * } public Coupon mapToEntity(CouponDto couponDto) { Coupon coupon= new
	 * Coupon(); coupon.setCouponId(couponDto.getCouponId());
	 * coupon.setCouponCode(couponDto.getCouponCode());
	 * coupon.setexpDate(couponDto.getExpDate()); return coupon; }
	 */

	@Override
	public CouponDto getByCouponCode(String couponCode) {
		//return couponrepository.getByCouponCode(couponCode);
		//List<CouponDto> couponDtos=new ArrayList<>();
		Coupon coupons=couponrepository.com(couponCode);
		//for(Coupon coupon:coupons)
			//couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		//return couponDtos;
		return modelMapper.map(coupons, CouponDto.class);
	
	}

	
	@Override
	public List<CouponDto> findByCouponCodeAndCouponId( String couponCode,int couponId) {
		
		List<CouponDto> couponDtos=new ArrayList<>();
		List<Coupon> coupons=couponrepository.com3(couponCode,couponId);
		for(Coupon coupon:coupons) {
			couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		}
			return couponDtos;
		
		//return couponrepository.findByCouponCodeAndCouponId(couponCode, couponId);
	}

	@Override
	public Coupon com(String couponCode) {
		return couponrepository.com(couponCode);
	}

	@Override
	public List<Coupon> com1(String couponCode, int couponId) {
		return couponrepository.com1(couponCode, couponId);
	}

	@Override
	public List<Coupon> com2(String couponCode, int couponId) {
		return couponrepository.com2(couponCode, couponId);
	}

	@Override
	public List<Coupon> com3(String couponCode, int couponId) {
		return couponrepository.com3(couponCode, couponId);
	}

	
}
