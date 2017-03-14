package com.ref.resources;

import com.ref.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * @description 跳转到登录页面
	 * @author xin
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/login");
		return view;
	}
	
	/**
	 * @description 跳转到注册页面
	 * @author xin
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/regist")
	public ModelAndView regist(HttpServletRequest request, Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/user/regist");
		return view;
	}
	
	/**
	 * @description 注册
	 * @author xin
	 * @param request
	 * @param name
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user/register")
	public Response register(HttpServletRequest request, String name, String password, String passwordConfirm){
		/*User userParam = userService.getUserByName(name);
		if(userParam != null) {
			return erroResult(WebConstant.USER_REGISTER_EXIT);
		}
		if(!password.trim().equals(passwordConfirm.trim())) {
			return erroResult(WebConstant.USER_REGISTER_PWD_NOT_SAME);
		}
		User user = new User(null, name.trim(), password.trim(), null, null);
		Long userId = userService.add(user, getOper(request, WebConstant.USER_REGISTER));
		setSession(request, new UserBind(userId, user.getName(), user.getPhone(), user.getEmail(), null, null));
		return successResult();*/
		return null;
	}
	
	/**
	 * @description 登录
	 * @author xin
	 * @param request
	 * @param name
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user/login")
	public Response login(HttpServletRequest request, String name, String password) {
//		Subject currentUser = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//		token.setRememberMe(true);
//		currentUser.login(token);
		
		/*User user = userService.getUserByName(name);
		if(user == null) {
			return erroResult(WebConstant.USER_LOGIN_NOT_EXIT);
		}
		String pwd = user.getPassword();
		if(!pwd.equals(password)) {
			return erroResult(WebConstant.USER_LOGIN_PWD_ERROR);
		}
		setSession(request, new UserBind(user.getId(), user.getName(), user.getPhone(), user.getEmail(), null, null));
		return successResult();*/
		return null;
	}
	
	/**
	 * @description 退出登录
	 * @author xin
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/user/signOut")
	public Response signOut(HttpServletRequest request) {
		/*removeSession(request);
		return successResult();*/
		return null;
	}
	
}
