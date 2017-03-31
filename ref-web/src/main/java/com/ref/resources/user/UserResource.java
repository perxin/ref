package com.ref.resources.user;

import com.ref.base.Resource.BaseResource;
import com.ref.constant.Constants;
import com.ref.model.user.User;
import com.ref.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(Constants.ROUTE_USER)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	@Autowired
	private UserService userService;

	@POST
	@Path(Constants.ROUTE_USER_REGISTER)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public Response register(@BeanParam User user) {
		userService.add(user);
		return returnSuccess();
	}

	@POST
	@Path(Constants.ROUTE_USER_LOGIN)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("name") String name, @FormParam("password") String password) {
		userService.postLogin(name, password);
		return returnSuccess();
	}

}
