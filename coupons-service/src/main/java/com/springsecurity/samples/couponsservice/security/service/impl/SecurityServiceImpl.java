package com.springsecurity.samples.couponsservice.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.springsecurity.samples.couponsservice.security.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(token);
		if(token.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return token.isAuthenticated();
		
	}

}
