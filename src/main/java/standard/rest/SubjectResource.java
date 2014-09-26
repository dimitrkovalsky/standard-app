package standard.rest;

import standard.beans.ISubjectBean;
import standard.errors.ApplicationException;
import standard.models.Subject;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/subjects")
@Stateless
public class SubjectResource {
    @Inject
    private ISubjectBean subjectBean;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subject> getAll() throws ApplicationException {
        return subjectBean.getAllSubjects();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Subject get(@PathParam("id") Integer id) throws ApplicationException {
        System.out.println("GET get : " + id);
        return subjectBean.getSubject(id);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String add(Subject data) throws ApplicationException {
        System.out.println("POST add : " + data);
        subjectBean.addSubject(data);
        return "Added Subject";
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(Subject data) throws ApplicationException {
        System.out.println("POST update : " + data);
        subjectBean.updateSubject(data);
        return "Updated Subject";
    }

    @DELETE
    @Path("{id}")
    public String delete(@PathParam("id") Integer id) {
        try {
            subjectBean.deleteSubject(id);
            return "Removed Subject with id : " + id;
        } catch(Exception e){
            System.err.println("[SubjectResource] error");
            return "Error removing Subject with id : " + id;
        }
    }
}