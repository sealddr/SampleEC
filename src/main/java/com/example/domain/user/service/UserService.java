package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.MOccupation;

public interface UserService {
	
	public List<MOccupation> getOccupations();

	public void signUp(MUser user);

	public MUser getLoginUser(String mailAddress);
}
