package com.ref.resources.user;

import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import com.ref.constant.Constants;
import com.ref.filter.TokenHolder;
import com.ref.model.user.Token;
import com.ref.model.user.User;
import com.ref.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Date;

@Path(Constants.ROUTE_USER)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	@Autowired
	private UserService userService;

	@POST
	@Path(Constants.ROUTE_USER_SIGN_UP)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response signUp(@FormParam("name") String name, @FormParam("password") String password) throws BusinessException {
		userService.add(name, password);
		return returnSuccess(CommonConstant.SUCCESS_JSON);
	}

	@POST
	@Path(Constants.ROUTE_USER_SIGN_IN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response signIn(@FormParam("name") String name, @FormParam("password") String password) {
		User user = userService.postLogin(name, password);
		Token token = new Token(user.getId(), user.getName(), null, null, new Date(), null, 60 * 60L);
		NewCookie cookie = new NewCookie("token", token.toString(), "/", null, null, 60 * 60, false);
		return Response.status(Status.OK).entity(CommonConstant.SUCCESS_JSON).cookie(cookie).type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path(Constants.ROUTE_USER_LOGOUT)
	public Response logout(@CookieParam("token") String token) {
		System.out.println(token);
        System.out.println(TokenHolder.getToken(token));
        System.out.println(TokenHolder.getUserId(token));
        NewCookie cookie = new NewCookie("token=", "", "/", null, null, 0, true);
		return Response.status(Status.OK).entity(CommonConstant.SUCCESS_JSON).cookie(cookie).type(MediaType.APPLICATION_JSON).build();
	}

}
