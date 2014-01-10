package com.my.mvc.service;

import java.util.List;

import com.my.mvc.vo.UserVO;

public interface UserService {

	public UserVO getUser(String userId);
	
	public void insertUser(UserVO userVO);
	
	public List<UserVO> getUserList();
	
	public void deleteUser(String userId);
	
}
