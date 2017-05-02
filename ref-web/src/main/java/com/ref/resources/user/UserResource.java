package com.ref.resources.user;

import com.ref.base.exception.BusinessException;
import com.ref.base.model.BaseResult;
import com.ref.constant.PathConstants;
import com.ref.model.user.User;
import com.ref.resources.BaseResource;
import com.ref.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserResource extends BaseResource {

    private Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

    @RequestMapping(PathConstants.ROUTE_MAIN_INDEX)
    public ModelAndView home() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/index");
        return view;
    }

	@RequestMapping(PathConstants.ROUTE_MAIN_SIGN)
	public ModelAndView sign() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/sign");
		return view;
	}

	@ResponseBody
	@RequestMapping(PathConstants.ROUTE_USER_SIGN_UP)
	public BaseResult signUp(HttpServletRequest request, String name, String password) throws BusinessException {
		try {
			User user = userService.add(name,password);
			setSession(request, user.getName(), user.getId());
			return successResult(user);
		} catch (BusinessException e) {
			return erroResult(e.getDescription());
		}
	}

	@ResponseBody
	@RequestMapping(PathConstants.ROUTE_USER_SIGN_IN)
	public BaseResult signIn(HttpServletRequest request, String name, String password) {
        try {
            User user = userService.postLogin(name, password);
            setSession(request, user.getName(), user.getId());
            return successResult();
        } catch (BusinessException e) {
            return erroResult(e.getDescription());
        }
	}

	@RequestMapping(PathConstants.ROUTE_USER_SIGNOUT)
	public ModelAndView signOut(HttpServletRequest request) {
		removeSession(request);
		return home();
	}

}
