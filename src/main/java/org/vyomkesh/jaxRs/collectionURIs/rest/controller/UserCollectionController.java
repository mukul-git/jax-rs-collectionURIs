package org.vyomkesh.jaxRs.collectionURIs.rest.controller;

import org.vyomkesh.jaxRs.collectionURIs.rest.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

@Path("users")
public class UserCollectionController extends BaseController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getUsers() {
        return new ArrayList<>();
    }

}
