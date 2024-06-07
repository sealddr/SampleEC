package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Occupation;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<Occupation> getOccupations() {
		return mapper.findAllOccupations();
	}

	@Override
	public void signUp(MUser user) {
		user.setRole("ROLE_GENERAL");

		user.setPassword(encoder.encode(user.getPassword()));
		mapper.insertOne(user);
	}

	@Override
	public MUser getLoginUser(String mailAddress) {
		return mapper.findLoginUser(mailAddress);
	}

}
