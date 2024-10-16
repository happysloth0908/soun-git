package com.ssafy.mvc.user.service;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDao;
	
	public UserServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String checkIdPass(String id, String pw) throws Exception {
		return userDao.checkIdPass(id,pw);
	}

}
