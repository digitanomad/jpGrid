package com.digitanomad.gridtest.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.digitanomad.gridtest.dao.UserDao;
import com.digitanomad.gridtest.dto.UserDto;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public List<UserDto> selectUserList() {
		return getSqlSession().selectList("selectUserList");
	}

	@Override
	public void insertUserList(List<UserDto> userList) {
		getSqlSession().insert("insertUserList", userList);
	}

}
