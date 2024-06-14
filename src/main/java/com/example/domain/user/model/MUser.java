package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
	private int userId;
	private String mailAddress;
	private String password;
	private String userName;
	private String furigana;
	private String phoneNumber;
	private Date birthday;
	private int occupationId;
	private String role;
	private MOccupation occupation;
	
}
