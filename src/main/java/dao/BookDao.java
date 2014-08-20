package dao;

import exception.DaoException;
import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookDao implements IBookDao {
    private EntityManager entityManager;

    public BookDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void insert(Book entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Book find(Book entity) throws DaoException {
        try {
            return entityManager.find(Book.class, entity.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Book> findAll() throws DaoException {
        try {
            CriteriaQuery<Book> criteria = entityManager.getCriteriaBuilder().createQuery(Book.class);
            criteria.select(criteria.from(Book.class));
            return entityManager.createQuery(criteria).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Book findById(Long id) throws DaoException {
        try {
            return entityManager.find(Book.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Book entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Book entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
