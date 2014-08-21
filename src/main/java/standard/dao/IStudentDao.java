package standard.dao;

import standard.errors.DaoException;
import standard.models.Student;

import java.util.List;

public interface IStudentDao {

    public void insert(Student entity) throws DaoException;

    public Student find(Student entity) throws DaoException;

    public List<Student> findAll() throws DaoException;

    public Student findById(Long id) throws DaoException;

    public void update(Student entity) throws DaoException;

    public void delete(Student entity) throws DaoException;
}