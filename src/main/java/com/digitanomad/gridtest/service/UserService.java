package com.digitanomad.gridtest.service;

import java.util.List;

import com.digitanomad.gridtest.dto.UserDto;

public interface UserService {

	List<UserDto> getUserList();
	void registerUserList(List<UserDto>userList);
}
