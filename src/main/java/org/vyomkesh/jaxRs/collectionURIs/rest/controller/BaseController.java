package org.vyomkesh.jaxRs.collectionURIs.rest.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}/* BaseController.SUPPORTED_DTO_TYPES */)
public abstract class BaseController {

    //public static final String[] SUPPORTED_DTO_TYPES = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML};
}
