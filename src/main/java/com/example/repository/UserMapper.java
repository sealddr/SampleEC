package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.MOccupation;

@Mapper
public interface UserMapper {
	
	public List<MOccupation> findAllOccupations();
	
	public int insertOne(MUser user);

	public MUser findLoginUser(String mailAddress);
}
