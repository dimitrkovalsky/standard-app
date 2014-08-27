package standard.dao;

import standard.errors.DaoException;
import standard.models.Account;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AccountDao implements IAccountDao {
    private EntityManager entityManager = null;

    public AccountDao(EntityManager em) {
        this.entityManager = em;
    }

    public void insert(Account entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Account find(Account entity) throws DaoException {
        try {
            return entityManager.find(Account.class, entity.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Account findByLogin(String login) throws DaoException {
        try {
            CriteriaBuilder builder =  entityManager.getCriteriaBuilder();
            CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
            Root<Account> root = criteria.from(Account.class);
            criteria.select(root).where(builder.equal(root.get("login"), login));
            return entityManager.createQuery(criteria).getSingleResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Account> findAll() throws DaoException {
        try {
            CriteriaQuery<Account> criteria = entityManager.getCriteriaBuilder().createQuery(Account.class);
            criteria.select(criteria.from(Account.class));
            return entityManager.createQuery(criteria).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Account findById(Long id) throws DaoException {
        try {
            return entityManager.find(Account.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void update(Account entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void delete(Account entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}