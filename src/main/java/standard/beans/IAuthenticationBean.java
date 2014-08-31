package standard.beans;

import standard.errors.ApplicationException;
import standard.errors.DaoException;
import standard.models.Account;

import javax.ejb.Stateless;

/**
 * Created by Dmytro_Kovalskyi on 22.08.2014.
 */
@Stateless
public interface IAuthenticationBean {
    Account authenticate(String login, String password) throws ApplicationException;
}
