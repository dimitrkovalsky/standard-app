package standard.beans;

import standard.commons.DaoFactory;
import standard.dao.IAccountDao;
import standard.errors.ApplicationException;
import standard.errors.DaoException;
import standard.models.Account;
import standard.models.Student;
import standard.requests.StudentRequest;
import standard.security.Encryptor;

/**
 * Created by Dmytro_Kovalskyi on 22.08.2014.
 */
public class AuthenticationBean implements IAuthenticationBean {
    @Override
    public Account authenticate(String login, String password) throws ApplicationException {
        IAccountDao dao = DaoFactory.getAccountDao();
        Account account = dao.findByLogin(login);
        if (account == null)
            return null;
        String encrypted = Encryptor.encrypt(password);
        if (encrypted.equals(account.getPassword()))
            return account;
        else
            return null;
    }

    public void registerStudent(StudentRequest studentRequest) throws ApplicationException {
        Account account = new Account();
        account.setLogin(studentRequest.getFirstName());
        account.setPassword(studentRequest.getFirstName());
        Student student = new Student();
    }

    private void createAccount(Account account) throws ApplicationException {
        IAccountDao dao = DaoFactory.getAccountDao();
        dao.insert(account);
    }
}
