package com.my.mvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.mvc.service.UserService;
import com.my.mvc.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	public ModelAndView getUser(Model model, @PathVariable String userId){
		logger.info("[getUser] method start with userId ========> " + userId);
		
		UserVO userVO = userService.getUser(userId);
		ModelAndView mav = new ModelAndView("XmlView", BindingResult.MODEL_KEY_PREFIX + "user", userVO);		
		return mav;
	}
	
	@RequestMapping(value = "/insertUserForm", method = RequestMethod.GET)
	public ModelAndView insertUserForm(Model model){
		logger.info("[insertUserForm] method start");
		UserVO userVO = new UserVO();
		ModelAndView mav = new ModelAndView("XmlView", BindingResult.MODEL_KEY_PREFIX, userVO);
		return mav;
	}
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public ModelAndView insertUser(Model model, @ModelAttribute("userVO") UserVO userVO) {
		logger.info("[insertUser] method start with user information ========> " + userVO.toString());
		userService.insertUser(userVO);
		UserVO userResultVO = userService.getUser(userVO.getUserId());
		ModelAndView mav = new ModelAndView("XmlView", BindingResult.MODEL_KEY_PREFIX + "user", userResultVO);	
		return mav;
	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public ModelAndView getUserList(Model model) {	
		logger.info("[getUserList] method start");
		List<UserVO> userList = userService.getUserList();
		ModelAndView mav = new ModelAndView("XmlView", BindingResult.MODEL_KEY_PREFIX + "user", userList);	
		return mav;	
	}
	
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	public ModelAndView deleteUser(Model model, @PathVariable String userId) {
		logger.info("[deleteUser] method start with user information ========> " + userId);
		userService.deleteUser(userId);
		List<UserVO> userList = userService.getUserList();
		ModelAndView mav = new ModelAndView("XmlView", BindingResult.MODEL_KEY_PREFIX + "user", userList);	
		return mav;
	}
	
}
