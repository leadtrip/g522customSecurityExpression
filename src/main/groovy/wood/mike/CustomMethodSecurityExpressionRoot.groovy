package wood.mike

import grails.core.GrailsControllerClass
import grails.web.api.WebAttributes
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.expression.SecurityExpressionRoot
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations
import org.springframework.security.core.Authentication

@Slf4j
class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations, WebAttributes {

    private Object filterObject;
    private Object returnObject;

    @Autowired
    ControllerActionPermissionService controllerActionPermissionService

    CustomMethodSecurityExpressionRoot(Authentication authentication, ControllerActionPermissionService caps) {
        super(authentication);
        controllerActionPermissionService = caps
    }

    boolean hasShiroPerms() {
        log.info "Checking SHIRO perms"

        String destController = getControllerName()
        String destAction = getActionName() ?: getControllerClass().defaultAction

        controllerActionPermissionService.isAllowed( authentication.principal.username, destController, destAction )
    }

    @Override
    Object getFilterObject() {
        return this.filterObject;
    }

    @Override
    Object getReturnObject() {
        return this.returnObject;
    }

    @Override
    Object getThis() {
        return this;
    }

    @Override
    void setFilterObject(Object obj) {
        this.filterObject = obj;
    }

    @Override
    void setReturnObject(Object obj) {
        this.returnObject = obj;
    }
}
