package standard.rest;

import standard.beans.IAuthenticationBean;
import standard.errors.DaoException;
import standard.models.Account;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 * User: dimitr
 * Date: 24.08.2014
 * Time: 13:38
 */
@Path("/auth")
@Stateless
public class AuthService {
    @Context
    private HttpServletRequest httpRequest;

    @Inject
    private IAuthenticationBean authenticationBean;

    @PermitAll
    @POST
    public String auth(@NotNull @FormParam("login") String login, @NotNull @FormParam("password") String password) throws DaoException {
        System.out.println("Session : " + httpRequest.getSession().getId());
        Account account = authenticationBean.authenticate(login, password);
        if (account == null)
            return "Error. Login or password is invalid.";
        httpRequest.getSession().setAttribute("login", login);
        return "OK";
    }
}
