package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Occupation;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public List<Occupation> getOccupations() {
		return mapper.findAllOccupations();
	}

	@Override
	public void buySignUp(MUser user) {
		user.setRole("ROLE_GENERAL");
		mapper.insertOne(user);
	}

}
