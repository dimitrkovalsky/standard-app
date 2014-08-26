package standard.rest;

import standard.beans.AuthenticationBean;
import standard.beans.IAuthenticationBean;
import standard.dao.IAccountDao;
import standard.errors.DaoException;
import standard.models.Account;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 * User: dimitr
 * Date: 24.08.2014
 * Time: 13:38
 */
@Path("/auth")
public class AuthService {
    @Context
    private HttpServletRequest httpRequest;

    @Inject
    private IAuthenticationBean authenticationBean;

    @PermitAll
    @POST
    public String auth(@FormParam("login") String login, @FormParam("password") String password) throws DaoException {
        System.out.println("Session : " + httpRequest.getSession().getId());
        Account account = authenticationBean.authenticate(login, password);
        if (account == null)
            return "Error. Login or password is invalid.";
        httpRequest.getSession().setAttribute("login", login);
        return "OK";
    }
}
