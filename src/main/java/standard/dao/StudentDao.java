package standard.dao;

import standard.errors.DaoException;
import standard.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StudentDao implements IStudentDao {
    private EntityManager entityManager = null;

    public StudentDao(EntityManager em) {
        this.entityManager = em;
    }

    public void insert(Student entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public Student find(Student entity) throws DaoException {
        try {
            return entityManager.find(Student.class, entity.getId());
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public List<Student> findAll() throws DaoException {
        try {
            CriteriaQuery<Student> criteria = entityManager.getCriteriaBuilder().createQuery(Student.class);
            criteria.select(criteria.from(Student.class));
            return entityManager.createQuery(criteria).getResultList();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public Student findById(Long id) throws DaoException {
        try {
            return entityManager.find(Student.class, id);
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void update(Student entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }

    public void delete(Student entity) throws DaoException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            throw new DaoException(e);
        }
    }
}