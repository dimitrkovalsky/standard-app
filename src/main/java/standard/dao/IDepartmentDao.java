package standard.dao;

import standard.errors.DaoException;
import standard.models.Department;

import java.util.List;

/**
 * User: dimitr
 * Date: 31.08.2014
 * Time: 13:27
 */
public interface IDepartmentDao {
    public void insert(Department entity) throws DaoException;

    public Department find(Department entity) throws DaoException;

    public List<Department> findAll() throws DaoException;

    public Department findById(Long id) throws DaoException;

    public Department findByName(String name) throws DaoException;

    public void update(Department entity) throws DaoException;

    public void delete(Department entity) throws DaoException;

    public List<Department> findByInstitute(Long id) throws DaoException;
}
