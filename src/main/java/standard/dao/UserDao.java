package standard.dao;

import standard.errors.DaoException;
import standard.models.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Dmytro_Kovalskyi on 21.08.2014.
 */
public class UserDao implements IUserDao {
    public UserDao(EntityManager em) {

    }

    @Override
    public void insert(User entity) throws DaoException {

    }

    @Override
    public User find(User entity) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public User findById(Long id) throws DaoException {
        User user1 = new User();
        user1.setId(id);
        user1.setFirstName("demo");
        user1.setLastName("user");
        user1.setUri("/user-management/users/1");
        return user1;
    }

    @Override
    public void update(User entity) throws DaoException {

    }

    @Override
    public void delete(User entity) throws DaoException {

    }
}
