package standard.rest;

import standard.commons.DaoFactory;
import standard.errors.DaoException;
import standard.models.Student;
import standard.security.Roles;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Dmytro_Kovalskyi on 18.08.2014.
 */
@Path("/students")
public class StudentResource {
    @GET
    @RolesAllowed(value = {Roles.STUDENT, Roles.LECTURER})
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<Student> list() throws DaoException {
        System.out.println("Students GET list");
        return DaoFactory.getStudentDao().findAll();
    }

    @POST
    @RolesAllowed(value = {Roles.LECTURER})
    public String add(@FormParam("data") String data) {
        System.out.println("Data : " + data);
        return "Added by " + data;
    }
}
