package standard.beans;

import java.lang.Integer;
import java.util.List;
import standard.commons.DaoFactory;
import standard.errors.ApplicationException;
import standard.models.Subject;

public class SubjectBean implements ISubjectBean {
    public Subject getSubject(Integer id) throws ApplicationException {
        return DaoFactory.getSubjectDao().findById(id);
    }

    public List<Subject> getAllSubjects() throws ApplicationException {
        return DaoFactory.getSubjectDao().findAll();
    }

    public void addSubject(Subject department) throws ApplicationException {
        ISubjectDao dao = DaoFactory.getSubjectDao();
        dao.insert(subject);
    }

    public void updateSubject(Subject department) throws ApplicationException {
        ISubjectDao dao = DaoFactory.getSubjectDao();
        dao.update(subject);
    }

    public void deleteSubject(Integer id) throws ApplicationException {
        ISubjectDao dao = DaoFactory.getSubjectDao();
        Subject subject = new Subject();
        subject.setId(id);
        dao.delete(subject);
    }
}