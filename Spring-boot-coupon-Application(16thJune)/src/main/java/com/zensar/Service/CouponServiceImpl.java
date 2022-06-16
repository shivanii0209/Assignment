package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.Repository.CouponRepository;
import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponrepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CouponDto getCoupon(int couponId) {
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

	@Override
	public List<CouponDto> getAllCoupon(int pageNumber,int pageSize) {
		//List<Coupon> listOfCoupons = couponrepository.findAll();
		List<CouponDto> listOfDto = new ArrayList<CouponDto>();
		Page<Coupon> findAll=couponrepository.findAll(PageRequest.of(pageNumber,pageSize));
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
	public void updateCoupon(int couponId, CouponDto couponDto) {
		//Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		couponrepository.save(coupon);

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
	public List<CouponDto> getByCouponCode(String couponCode) {
		//return couponrepository.getByCouponCode(couponCode);
		List<CouponDto> couponDtos=new ArrayList<>();
		List<Coupon> coupons=couponrepository.com(couponCode);
		for(Coupon coupon:coupons)
			couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		return couponDtos;
	}

	
	@Override
	public List<CouponDto> findByCouponCodeAndCouponId( String couponCode,int couponId) {
		
		List<CouponDto> couponDtos=new ArrayList<>();
		List<Coupon> coupons=couponrepository.com3(couponCode,couponId);
		for(Coupon coupon:coupons)
			couponDtos.add(modelMapper.map(coupon, CouponDto.class));
		return couponDtos;
		
		//return couponrepository.findByCouponCodeAndCouponId(couponCode, couponId);
	}

	@Override
	public List<Coupon> com(String couponCode) {
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
