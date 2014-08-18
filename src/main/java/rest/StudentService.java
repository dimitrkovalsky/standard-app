package rest;

import model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Dmytro_Kovalskyi on 18.08.2014.
 */
@Path("/students")
public class StudentService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student get() {
        System.out.println("Students GET");
        return new Student("Oleg", 22);
    }

    @POST
    public String add(@FormParam("token") String token) {
        System.out.println("Token : " + token);
        return "Added by " + token;
    }

}
