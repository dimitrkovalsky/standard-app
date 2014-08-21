package standard.rest;

import standard.commons.DaoFactory;
import standard.errors.DaoException;
import standard.models.User;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

/**
 * Created by Dmytro_Kovalskyi on 21.08.2014.
 */
@Path("/user-service")
public class UserService {
    @PermitAll
    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id, @Context Request req)  {
        System.out.println("getUserById : " + id);
        try {
            return DaoFactory.getUserDao().findById(id);
        } catch (DaoException e) {
           return null;
        }
    }

    @RolesAllowed("ADMIN")
    @PUT
    @Path("/users/{id}")
    public void updateUserById(@PathParam("id") int id) {
        System.out.println("UPDATED : " + id);
    }
}
