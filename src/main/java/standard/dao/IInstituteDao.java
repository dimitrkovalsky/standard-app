package standard.dao;

import java.util.List;
import java.lang.Long;
import standard.models.Institute;
import standard.errors.DaoException;

public interface IInstituteDao {

    public void insert(Institute entity) throws DaoException;

    public Institute find(Institute entity) throws DaoException;

    public List<Institute> findAll() throws DaoException;

    public Institute findById(Long id) throws DaoException;

    public void update(Institute entity) throws DaoException;

    public void delete(Institute entity) throws DaoException;
}