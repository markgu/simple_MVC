/**
 * 
 */
package com.my.mvc.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.mvc.vo.UserVO;

/**
 * @author Gu
 *
 */
public class MapDataSourceTest {
		
	MapDataSource mapDataSource = new MapDataSource();
	UserVO user1 = new UserVO("1","1","1","1","1");
	UserVO user2 = new UserVO("2","2","2","2","2");
	UserVO user3 = new UserVO("3","3","3","3","3");
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.my.mvc.dao.MapDataSource#MapDataSource()}.
	 */
	@Test
	public void testMapDataSource() {
		assertEquals(user1.toString(), mapDataSource.getUser("1").toString());
		assertEquals(user2.toString(), mapDataSource.getUser("2").toString());
		assertEquals(user3.toString(), mapDataSource.getUser("3").toString());		
	}

	/**
	 * Test method for {@link com.my.mvc.dao.MapDataSource#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUser() {
		UserVO resultUser1 = mapDataSource.getUser(user1.getUserId());
		assertEquals(resultUser1.getUserId(), user1.getUserId());
		assertEquals(resultUser1.getAddress(), user1.getAddress());		
	}

	/**
	 * Test method for {@link com.my.mvc.dao.MapDataSource#insertUser(com.my.mvc.vo.UserVO)}.
	 */
	@Test
	public void testInsertUser() {
		UserVO testUser = new UserVO("testUserId","testUserName","testAddress","","");
		mapDataSource.insertUser(testUser);
		assertEquals(mapDataSource.getUser(testUser.getUserId()).toString(), testUser.toString());		
	}

	/**
	 * Test method for {@link com.my.mvc.dao.MapDataSource#getUserList()}.
	 */
	@Test
	public void testGetUserList() {
		mapDataSource.deleteAllUsers();
		mapDataSource.insertUser(user1);
		assertEquals(mapDataSource.getUserList().size(),1);
		mapDataSource.insertUser(user2);
		List<UserVO> userList = new ArrayList<UserVO>();		
		userList.add(user2);
		userList.add(user1);
		assertEquals(mapDataSource.getUserList(), userList.subList(0, 2));
	}

	/**
	 * Test method for {@link com.my.mvc.dao.MapDataSource#deleteUser(java.lang.String)}.
	 */
	@Test
	public void testDeleteUser() {
		mapDataSource.deleteAllUsers();
		mapDataSource.insertUser(user1);
		mapDataSource.deleteUser(user1.getUserId());
		assertNull(mapDataSource.getUser(user1.getUserId()));
		
	}

	@Test
	public void testDeleteAllUsers(){
		mapDataSource.deleteAllUsers();
		assertEquals(mapDataSource.getUserList().size(), 0);
	}


}
