package standard.dao;

import standard.errors.DaoException;
import standard.models.Department;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * User: dimitr
 * Date: 31.08.2014
 * Time: 13:28
 */
public class DepartmentDao implements IDepartmentDao {
    private EntityManager entityManager = null;

    public DepartmentDao(EntityManager em) {
        this.entityManager = em;
    }

    public void insert(Department entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Department find(Department entity) throws DaoException {
        try {
            return entityManager.find(Department.class, entity.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Department findByName(String name) throws DaoException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Department> criteria = builder.createQuery(Department.class);
            Root<Department> root = criteria.from(Department.class);
            criteria.select(root).where(builder.equal(root.get("login"), name));
            return entityManager.createQuery(criteria).getSingleResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Department> findByInstitute(Long id) throws DaoException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Department> criteria = builder.createQuery(Department.class);
            Root<Department> root = criteria.from(Department.class);
            criteria.select(root).where(builder.equal(root.get("instituteId"), id));
            return entityManager.createQuery(criteria).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    public List<Department> findAll() throws DaoException {
        try {
            CriteriaQuery<Department> criteria = entityManager.getCriteriaBuilder().createQuery(Department.class);
            criteria.select(criteria.from(Department.class));
            return entityManager.createQuery(criteria).getResultList();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Department findById(Long id) throws DaoException {
        try {
            return entityManager.find(Department.class, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void update(Department entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    // TODO: Change delete method generation
    public void delete(Department entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            Department toBeRemoved = entityManager.merge(entity);
            entityManager.remove(toBeRemoved);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
