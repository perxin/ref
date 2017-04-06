package com.ref.resources.user;

import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import com.ref.constant.Constants;
import com.ref.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(Constants.ROUTE_USER)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	@Autowired
	private UserService userService;

	@POST
	@Path(Constants.ROUTE_USER_REGISTER)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@FormParam("name") String name, @FormParam("password") String password) throws BusinessException {
		userService.add(name, password);
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}



	@POST
	@Path(Constants.ROUTE_USER_LOGIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("name") String name, @FormParam("password") String password) {
		userService.postLogin(name, password);
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}

	@GET
	@Path("/a")
	public Response a() {
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}

}
