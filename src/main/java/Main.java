import standard.commons.DaoFactory;
import standard.dao.IAccountDao;
import standard.dao.IDepartmentDao;
import standard.dao.IInstituteDao;
import standard.dao.IStudentDao;
import standard.errors.DaoException;
import standard.models.Account;
import standard.models.Department;
import standard.models.Institute;
import standard.models.Student;
import standard.security.Encryptor;
import standard.security.Roles;


public class Main {
    public static void main(String[] args) throws DaoException {
        fillDepartments();
        //System.out.println(DaoFactory.getAccountDao().findByLogin("acc_1"));
    }

    public static void fillInstitutes() throws DaoException {
        IInstituteDao dao = DaoFactory.getInstituteDao();
        for (long i = 1; i <= 5; i++) {
            Institute institute = new Institute();
            institute.setName("Institute_" + i);
            institute.setHead(i);
            dao.insert(institute);
        }
    }

    public static void fillDepartments() throws DaoException {
        IDepartmentDao dao = DaoFactory.getDepartmentDao();
        for (long i = 1; i <= 5; i++) {
            Department department = new Department();
            department.setName("Dep_" + i);
            department.setInstitute(1L);
            dao.insert(department);
        }
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
        IAccountDao dao = DaoFactory.getAccountDao();
        for (long i = 1; i <= 10; i++) {
            Account account = new Account();
            account.setId(i);
            account.setLogin("acc_" + i);
            account.setPassword(Encryptor.encrypt("acc_" + i));
            account.setRole(Roles.STUDENT);
            dao.insert(account);
        }
    }
}