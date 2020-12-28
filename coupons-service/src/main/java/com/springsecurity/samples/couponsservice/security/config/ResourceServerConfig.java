package com.springsecurity.samples.couponsservice.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "couponservice";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		
		http.authorizeRequests()
		.mvcMatchers(HttpMethod.GET, "/couponapi/coupons/{code:^[A-Z0-9]+$}")
			.hasAnyRole("USER","ADMIN")
		.mvcMatchers(HttpMethod.POST, "/couponapi/coupons")
			.hasRole("ADMIN")
		.mvcMatchers("/h2-console/**").permitAll()
		.anyRequest().denyAll().and().csrf().disable();
		System.out.println("Oauth2: ResourceServerConfig");
	}
}
