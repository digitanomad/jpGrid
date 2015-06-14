package com.digitanomad.gridtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitanomad.gridtest.dao.UserDao;
import com.digitanomad.gridtest.dto.UserDto;
import com.digitanomad.gridtest.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public List<UserDto> getUserList() {
		return userDao.selectUserList();
	}

	@Override
	public void registerUserList(List<UserDto> userList) {
		userDao.insertUserList(userList);
	}
	
}
