package standard.dao;

import standard.errors.DaoException;
import standard.models.User;

import java.util.List;

/**
 * Created by Dmytro_Kovalskyi on 21.08.2014.
 */
public interface IUserDao {
    public void insert(User entity) throws DaoException;

    public User find(User entity) throws DaoException;

    public List<User> findAll() throws DaoException;

    public User findById(Long id) throws DaoException;

    public void update(User entity) throws DaoException;

    public void delete(User entity) throws DaoException;
}
