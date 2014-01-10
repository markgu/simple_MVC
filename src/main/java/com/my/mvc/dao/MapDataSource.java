package com.my.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.my.mvc.vo.UserVO;

@Component("mapDataSource")
public class MapDataSource {
	
	public MapDataSource(){
		userMap = Maps.newHashMap();
		UserVO user1 = new UserVO("1","1","1","1","1");
		UserVO user2 = new UserVO("2","2","2","2","2");
		UserVO user3 = new UserVO("3","3","3","3","3");
		insertUser(user1);
		insertUser(user2);
		insertUser(user3);
	}
	
	private Map<String,UserVO> userMap;
	
	public UserVO getUser(String userId){
		return userMap.get(userId);
	}
	
	public void insertUser(UserVO userVO){
		userMap.put(userVO.getUserId(), userVO);
	}
	
	public List<UserVO> getUserList(){
		return Lists.newArrayList(userMap.values());
	}
	
	public void deleteUser(String userId){
		userMap.remove(userId);
	}
	
	public void deleteAllUsers(){
		userMap.clear();
	}

}
