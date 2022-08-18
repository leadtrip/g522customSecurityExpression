package wood.mike

import grails.web.api.WebAttributes
import groovy.util.logging.Slf4j
import org.springframework.security.core.Authentication
import org.springframework.security.web.FilterInvocation
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot

@Slf4j
class CustomWebSecurityExpressionRoot extends WebSecurityExpressionRoot implements WebAttributes {

    ControllerActionPermissionService controllerActionPermissionService

    CustomWebSecurityExpressionRoot(Authentication a, FilterInvocation fi, ControllerActionPermissionService caps) {
        super(a, fi)
        controllerActionPermissionService = caps
    }

    boolean hasCustomPermission() {
        log.info "Checking custom permission"

        String destController = getControllerName()
        String destAction = getActionName() ?: getControllerClass().defaultAction

        controllerActionPermissionService.isAllowed( authentication.principal.username, destController, destAction )
    }
}
