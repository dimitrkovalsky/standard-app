import standard.commons.DaoFactory;
import standard.dao.IStudentDao;
import standard.errors.DaoException;
import standard.models.Student;
import standard.security.Encryptor;


public class Main {
    public static void main(String[] args) throws DaoException {
        System.out.println(Encryptor.encrypt("ss"));
    }

    public static void fillStudents() throws DaoException {
        IStudentDao dao = DaoFactory.getStudentDao();
        for (long i = 1; i <= 10; i++) {
            Student student = new Student();
            student.setId(i);
            student.setFirstName("Name #" + i);
            student.setLastName("Surname for " + i);
            student.setDepartment("KSU");
            dao.insert(student);
        }
    }

    public static void fillAccounts() throws DaoException {
        IStudentDao dao = DaoFactory.getStudentDao();
        for (long i = 1; i <= 10; i++) {
            Student student = new Student();
            student.setId(i);
            student.setFirstName("Name #" + i);
            student.setLastName("Surname for " + i);
            student.setDepartment("KSU");
            dao.insert(student);
        }
    }
}