package com.springsecurity.samples.productservice.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Coupon {

	private  Long id;
	private  String code;
	private  BigDecimal discount;
	private  String expdate;
}
