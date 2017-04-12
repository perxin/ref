package com.ref.service;

import com.ref.resources.note.NoteResource;
import com.ref.resources.user.UserResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ServiceApplication extends ResourceConfig {

    public ServiceApplication() {
        // register application resources
        register(UserResource.class);
        register(NoteResource.class);

        // register filters

        // register exception mappers

        // register features
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
