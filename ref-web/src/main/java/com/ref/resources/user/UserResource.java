package com.ref.resources.user;

import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import com.ref.base.model.UserBind;
import com.ref.base.util.JsonUtil;
import com.ref.constant.Constants;
import com.ref.model.user.User;
import com.ref.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path(Constants.ROUTE_USER)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	@Autowired
	private UserService userService;

	@POST
	@Path(Constants.ROUTE_USER_REGISTER)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response register(@FormParam("name") String name, @FormParam("password") String password) throws BusinessException {
		userService.add(name, password);
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}

	@POST
	@Path(Constants.ROUTE_USER_LOGIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@Context HttpServletRequest request, @FormParam("name") String name, @FormParam("password") String password) {
		User user = userService.postLogin(name, password);
		UserBind userBind = new UserBind(user.getId(), user.getName(), user.getPhone(), user.getEmail(), new Date(), request.getRemoteAddr());
		setSession(request, userBind);
		return returnSuccess(JsonUtil.objectToJson(userBind));
	}

	@PUT
	@Path(Constants.ROUTE_USER_LOGOUT)
	public Response logout(HttpServletRequest request, @PathParam("userId") String userId) {
		removeSession(request, userId);
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}

	@GET
	@Path("/a")
	public Response a() {
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}

}
