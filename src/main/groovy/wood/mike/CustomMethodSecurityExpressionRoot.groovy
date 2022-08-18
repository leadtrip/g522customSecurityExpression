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


    CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication)
    }

    /**
     * Custom permission method, just letting everything through
     */
    boolean hasCustomMethodPermission() {
        log.info "Checking custom method permission"

        true
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
