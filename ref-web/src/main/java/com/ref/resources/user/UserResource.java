package com.ref.resources.user;

import com.ref.base.Resource.BaseResource;
import com.ref.base.constant.CommonConstant;
import com.ref.base.exception.BusinessException;
import com.ref.base.util.RSAUtil;
import com.ref.constant.PathConstants;
import com.ref.model.user.User;
import com.ref.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path(PathConstants.ROUTE_USER)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

    private Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	@POST
	@Path(PathConstants.ROUTE_USER_SIGN_UP)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response signUp(@FormParam("name") String name, @FormParam("password") String password) throws BusinessException {
		User user = userService.add(name, password);
		NewCookie cookie = new NewCookie("token", RSAUtil.encryptByPublicKey(user.getId().toString(),RSAUtil.STR_PUBLIC_KEY), "/", null, null, 60 * 60, false);
		return Response.status(Status.OK).entity(CommonConstant.SUCCESS_JSON).cookie(cookie).type(MediaType.APPLICATION_JSON).build();
}

	@POST
	@Path(PathConstants.ROUTE_USER_SIGN_IN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response signIn(@FormParam("name") String name, @FormParam("password") String password) {
		User user = userService.postLogin(name, password);
		NewCookie cookie = new NewCookie("token", RSAUtil.encryptByPublicKey(user.getId().toString(),RSAUtil.STR_PUBLIC_KEY), "/", null, null, 60 * 60, false);
		return Response.status(Status.OK).entity(CommonConstant.SUCCESS_JSON).cookie(cookie).type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path(PathConstants.ROUTE_USER_SIGNOUT)
	public Response signOut(@CookieParam("token") String token) {
		log.info(getLoginUserId(token) + "");
        NewCookie cookie = new NewCookie("token", "", "/", null, null, 0, false);
		return Response.status(Status.OK).entity(CommonConstant.SUCCESS_JSON).cookie(cookie).type(MediaType.APPLICATION_JSON).build();
	}

}
