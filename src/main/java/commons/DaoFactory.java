package commons;

import dao.BookDao;
import dao.IBookDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by Dmytro_Kovalskyi on 23.07.2014.
 */
public class DaoFactory {
    private static String PERSISTENT_UNIT = "chapter04PU";
    @PersistenceContext
    private static EntityManager em = null;

    static {
        em = Persistence.createEntityManagerFactory(PERSISTENT_UNIT).createEntityManager();
    }

    public static IBookDao getBookDao() {
        return new BookDao(em);
    }
}
