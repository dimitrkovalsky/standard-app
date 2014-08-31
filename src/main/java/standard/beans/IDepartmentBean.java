package standard.beans;

import standard.commons.DaoFactory;
import standard.dao.IDepartmentDao;
import standard.errors.ApplicationException;
import standard.models.Department;

import java.util.List;

/**
 * User: dimitr
 * Date: 31.08.2014
 * Time: 13:33
 */
public class IDepartmentBean {
    public List<Department> getAllDepartments() throws ApplicationException {
       return DaoFactory.getDepartmentDao().findAll();
    }

    public void addDepartment(Department department) throws ApplicationException {
        IDepartmentDao dao = DaoFactory.getDepartmentDao();
        dao.insert(department);
    }

    public void updateDepartment(Department department) throws ApplicationException {
        IDepartmentDao dao = DaoFactory.getDepartmentDao();
        dao.update(department);
    }

    public void deleteDepartment(Long id) throws ApplicationException {
        IDepartmentDao dao = DaoFactory.getDepartmentDao();
        Department department = new Department();
        department.setId(id);
        dao.delete(department);
    }
}
