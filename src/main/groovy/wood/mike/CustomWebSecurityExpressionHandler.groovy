package wood.mike

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.expression.SecurityExpressionOperations
import org.springframework.security.authentication.AuthenticationTrustResolver
import org.springframework.security.authentication.AuthenticationTrustResolverImpl
import org.springframework.security.core.Authentication
import org.springframework.security.web.FilterInvocation
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler

class CustomWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {

    @Autowired
    ControllerActionPermissionService controllerActionPermissionService

    private AuthenticationTrustResolver trustResolver =
            new AuthenticationTrustResolverImpl();

    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
                                                                        FilterInvocation fi) {
        CustomWebSecurityExpressionRoot root = new CustomWebSecurityExpressionRoot(authentication, fi, controllerActionPermissionService);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(this.trustResolver);
        root.setRoleHierarchy(getRoleHierarchy());
        root.setDefaultRolePrefix('ROLE_');
        return root;
    }

}
