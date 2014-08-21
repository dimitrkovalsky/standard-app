package standard.rest;

import standard.commons.DaoFactory;
import standard.errors.DaoException;
import standard.models.Student;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Dmytro_Kovalskyi on 18.08.2014.
 */
@Path("/students")
public class StudentResource {
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<Student> list() throws DaoException {
        System.out.println("Students GET list");
        return DaoFactory.getStudentDao().findAll();
    }

    @POST
    public String add(@FormParam("token") String token) {
        System.out.println("Token : " + token);
        return "Added by " + token;
    }
}
