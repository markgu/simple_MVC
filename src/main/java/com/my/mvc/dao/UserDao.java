package com.my.mvc.dao;

import java.util.List;

import com.google.common.collect.Lists;
import com.my.mvc.vo.UserVO;

public interface UserDao {
	
	public UserVO getUser(String userId);	
	
	public void insertUser(UserVO userVO);
	
	public List<UserVO> getUserList();
	
	public void deleteUser(String userId);

}
