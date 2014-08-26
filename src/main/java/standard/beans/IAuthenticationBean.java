package standard.beans;

import standard.errors.DaoException;

import javax.ejb.Stateless;

/**
 * Created by Dmytro_Kovalskyi on 22.08.2014.
 */
@Stateless
public interface IAuthenticationBean {
    standard.models.Account authenticate(String login, String password) throws DaoException;
}
