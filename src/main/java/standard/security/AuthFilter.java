package standard.security;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//
//@Provider
//public class AuthFilter implements ContainerRequestFilter {

public class AuthFilter {
    @Context
    private HttpServletRequest httpRequest;
    public static final String LOGIN = "login";
    public static final String ROLE = "role";
    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());
    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());
    private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<Object>());

    public void filter(ContainerRequestContext requestContext) {

        ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
        Method method = methodInvoker.getMethod();
        //Access allowed for all
        if (!method.isAnnotationPresent(PermitAll.class)) {
            if (method.isAnnotationPresent(DenyAll.class)) {
                requestContext.abortWith(ACCESS_FORBIDDEN);
                return;
            }
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
            HttpSession session = httpRequest.getSession();
            if (session == null) {
                requestContext.abortWith(ACCESS_DENIED);
                return;
            }
            String login = (String) session.getAttribute(LOGIN);
            String role = (String) session.getAttribute(ROLE);

            if (login == null || login.isEmpty() || role == null || role.isEmpty()) {
                requestContext.abortWith(ACCESS_DENIED);
                return;
            }

            if (method.isAnnotationPresent(RolesAllowed.class)) {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

                if (!isUserAllowed(login, role, rolesSet)) {
                    requestContext.abortWith(ACCESS_DENIED);
                    return;
                }
            }
        }
    }

    private boolean isUserAllowed(final String login, final String role, final Set<String> rolesSet) {
        boolean isAllowed = false;

        if (rolesSet.contains(role)) {
            isAllowed = true;
        }
        return isAllowed;
    }


}