package com.springsecurity.samples.couponsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.samples.couponsservice.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
