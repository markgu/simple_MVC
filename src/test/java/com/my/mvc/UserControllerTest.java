package com.my.mvc;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.my.mvc.dao.MapDataSource;
import com.my.mvc.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserControllerTest {
	
	/*@Autowired
	private UserService userService;*/
	
	@Autowired
	private UserController userController;
	
	private MapDataSource mds = new MapDataSource();
	
	UserVO user1 = new UserVO("1","1","1","1","1");
	UserVO user2 = new UserVO("2","2","2","2","2");
	UserVO user3 = new UserVO("3","3","3","3","3");
	
	List<UserVO> userList = mds.getUserList();
	List<UserVO> userListComp = Lists.newArrayList();
	
	private ModelAndView mav = new ModelAndView();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUser() {		
		//MockHttpServletRequest request = new MockHttpServletRequest();
		//MockHttpServletResponse response = new MockHttpServletResponse();
		
		mds.deleteAllUsers();
		mds.insertUser(user1);		
		mav = userController.getUser(null, user1.getUserId());		
		
		assertNotNull(mav);		
		assertEquals(((UserVO)mav.getModel().get("org.springframework.validation.BindingResult.user")).toString(), user1.toString());
	}

	@Test
	public void testInsertUserForm() {
		
	}

	@Test
	public void testInsertUser() {
		mav = userController.insertUser(null, user2);
		
		assertNotNull(mav);
		assertEquals(((UserVO)mav.getModel().get("org.springframework.validation.BindingResult.user")).toString(), user2.toString());		
	}

	@Test
	public void testGetUserList() {
		mds.deleteAllUsers();
		mds.insertUser(user1);
		mds.insertUser(user2);
		mds.insertUser(user3);
		mav = userController.getUserList(null);		

		//System.out.println("getModel =======> " + mav.getModel());
		//System.out.println("userList.toString() =======> " + userList.toString());
		//System.out.println("toString =======> " + mav.toString());
		
		System.out.println("userListComp iterator start" );
		Iterator it = mav.getModel().values().iterator();
		while(it.hasNext()){			
			System.out.println("iterator =======> " + it.next());
			userListComp.add((UserVO)it.next());
			System.out.println("userListComp .toString() =======> " + userListComp.toString());
		}		
		assertNotNull(mav);
		//assertSame( mav.getModel().values().toString(), userList.toString());
		assertEquals( userListComp, userList);
		
	}

	@Test
	public void testDeleteUser() {
		
	}

}
