package standard.dao;

import standard.errors.DaoException;
import standard.models.Account;

import java.util.List;

public interface IAccountDao {

    public void insert(Account entity) throws DaoException;

    public Account find(Account entity) throws DaoException;

    public List<Account> findAll() throws DaoException;

    public Account findById(Long id) throws DaoException;

    public Account findByLogin(String login) throws DaoException;

    public void update(Account entity) throws DaoException;

    public void delete(Account entity) throws DaoException;
}
