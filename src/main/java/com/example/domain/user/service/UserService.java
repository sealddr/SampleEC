package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.Occupation;

public interface UserService {
	
	public List<Occupation> getOccupations();

	public void signUp(MUser user);

	public MUser getLoginUser(String mailAddress);
}
