package com.ref.service;

import com.ref.resources.StaticResource;
import com.ref.resources.note.NoteResource;
import com.ref.resources.user.UserResource;
import com.ref.service.system.FileResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class ServiceApplication extends ResourceConfig {

    public ServiceApplication() {
        // register application resources
        register(UserResource.class);
        register(NoteResource.class);
        register(FileResource.class);
        register(StaticResource.class);

        // register filters

        // register exception mappers

        // register features
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/src/main/webapp/WEB-INF/views");
    }
}
