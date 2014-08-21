package standard.dao;

import standard.errors.DaoException;
import standard.models.Book;

import java.util.List;

/**
 * Created by Dmytro_Kovalskyi on 23.07.2014.
 */
public interface IBookDao {
    public void insert(Book entity) throws DaoException;

    public Book find(Book entity) throws DaoException;

    public List<Book> findAll() throws DaoException;

    public Book findById(Long id) throws DaoException;

    public void update(Book entity) throws DaoException;

    public void delete(Book entity) throws DaoException;
}
