package standard.dao;

import java.lang.Exception;
import java.lang.Long;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import standard.errors.DaoException;
import standard.models.Institute;

public class InstituteDao implements IInstituteDao {
    private EntityManager entityManager = null;

    public InstituteDao(EntityManager em){
        this.entityManager = em;
    }

    public void insert(Institute entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public Institute find(Institute entity) throws DaoException {
        try {
            return entityManager.find(Institute.class, entity.getId());
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public List<Institute> findAll() throws DaoException {
        try {
            CriteriaQuery<Institute> criteria = entityManager.getCriteriaBuilder().createQuery(Institute.class);
            criteria.select(criteria.from(Institute.class));
            return entityManager.createQuery(criteria).getResultList();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public Institute findById(Long id) throws DaoException {
        try {
            return entityManager.find(Institute.class, id);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void update(Institute entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void delete(Institute entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }
}