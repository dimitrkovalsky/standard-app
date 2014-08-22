package standard.dao;

import standard.errors.DaoException;
import standard.models.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserRoleDao implements IUserRoleDao {
    private EntityManager entityManager = null;

    public UserRoleDao(EntityManager em){
        this.entityManager = em;
    }

    public void insert(UserRole entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public UserRole find(UserRole entity) throws DaoException {
        try {
            return entityManager.find(UserRole.class, entity.getId());
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public List<UserRole> findAll() throws DaoException {
        try {
            CriteriaQuery<UserRole> criteria = entityManager.getCriteriaBuilder().createQuery(UserRole.class);
            criteria.select(criteria.from(UserRole.class));
            return entityManager.createQuery(criteria).getResultList();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public UserRole findById(Long id) throws DaoException {
        try {
            return entityManager.find(UserRole.class, id);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void update(UserRole entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void delete(UserRole entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }
}