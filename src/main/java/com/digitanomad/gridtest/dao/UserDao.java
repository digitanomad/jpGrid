package com.digitanomad.gridtest.dao;

import java.util.List;

import com.digitanomad.gridtest.dto.UserDto;

public interface UserDao {
	
	List<UserDto> selectUserList();
	void insertUserList(List<UserDto> userList);
}
