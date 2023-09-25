package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Occupation;

public interface UserService {
	
	public List<Occupation> getOccupations();

	public void buySignUp(MUser user);
}
