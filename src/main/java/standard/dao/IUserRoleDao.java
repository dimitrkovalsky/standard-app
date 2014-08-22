package standard.dao;

import standard.errors.DaoException;
import standard.models.UserRole;

import java.util.List;

public interface IUserRoleDao {

    public void insert(UserRole entity) throws DaoException;

    public UserRole find(UserRole entity) throws DaoException;

    public List<UserRole> findAll() throws DaoException;

    public UserRole findById(Long id) throws DaoException;

    public void update(UserRole entity) throws DaoException;

    public void delete(UserRole entity) throws DaoException;
}
