package com.springsecurity.samples.couponsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springsecurity.samples.couponsservice.model.Coupon;
import com.springsecurity.samples.couponsservice.repository.CouponRepository;

@Controller
public class CouponController {

	@Autowired
	private CouponRepository couponRepo;
	
	@GetMapping("/showCreateCoupon")
	public String showCreateCoupon() {
		return "createCoupon";
	}
	
	
	@PostMapping("/saveCoupon")
	public String saveCoupon(Coupon coupon) {
		couponRepo.save(coupon);
		return "createResponse";
	}
	
	
	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCoupon";
	}
	
	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView mv = new ModelAndView("couponDetails");
		mv.addObject(couponRepo.findByCode(code));
		return mv;
	}
	
}
