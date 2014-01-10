package com.my.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.mvc.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private MapDataSource mapDataSource;

	public UserVO getUser(String userId) {
		return mapDataSource.getUser(userId);
	}

	public void insertUser(UserVO userVO) {		
		mapDataSource.insertUser(userVO);		
	}

	public List<UserVO> getUserList() {		
		return mapDataSource.getUserList();
	}

	public void deleteUser(String userId) {		
		mapDataSource.deleteUser(userId);
	}

}
