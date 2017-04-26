package com.ref.resources;

import com.ref.constant.PathConstants;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.Path;
import java.io.IOException;

@Path(PathConstants.ROUTE_MAIN)
public class StaticResource {

    @Path(PathConstants.ROUTE_MAIN_INDEX)
    public Viewable index() throws IOException {
       return  new Viewable("/views/index.jsp");
    }
}
