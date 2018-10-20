package com.gecko.demo.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
//@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface HelloResource {

    @GET
    @Path("{name}")
    @ApiOperation(value="Gets stomething", notes = "boo", response = String.class)
    @ApiResponses(value={
        @ApiResponse(code=200, message="Found, ", response = String.class)
    })
    String greet(@PathParam("name") String name) throws Exception;
}
