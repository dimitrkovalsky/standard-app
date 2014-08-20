package rest;

import commons.DaoFactory;
import dao.IBookDao;
import exception.DaoException;
import models.Book;
import models.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Dmytro_Kovalskyi on 18.08.2014.
 */
@Path("/students")
public class StudentService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student get() throws DaoException {
        System.out.println("Students GET");
        IBookDao dao = DaoFactory.getBookDao();
        for (Book b : dao.findAll())
            System.out.println(b);
        return new Student("Oleg", 22);
    }

    @POST
    public String add(@FormParam("token") String token) {
        System.out.println("Token : " + token);
        return "Added by " + token;
    }

}
