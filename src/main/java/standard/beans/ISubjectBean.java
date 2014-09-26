package standard.beans;

import standard.errors.ApplicationException;
import standard.models.Subject;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ISubjectBean {

    public Subject getSubject(Integer id) throws ApplicationException;

    public List<Subject> getAllSubjects() throws ApplicationException;

    public void addSubject(Subject department) throws ApplicationException;

    public void updateSubject(Subject department) throws ApplicationException;

    public void deleteSubject(Integer id) throws ApplicationException;
}