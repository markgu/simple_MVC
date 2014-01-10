package com.my.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.mvc.dao.UserDao;
import com.my.mvc.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserVO getUser(String userId) {
		return userDao.getUser(userId);
	}

	public void insertUser(UserVO userVO) {
		userDao.insertUser(userVO);		
	}

	public List<UserVO> getUserList() {
		return userDao.getUserList();
	}

	public void deleteUser(String userId) {
		userDao.deleteUser(userId);		
	}

}
