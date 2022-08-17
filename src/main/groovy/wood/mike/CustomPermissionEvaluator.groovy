package wood.mike

import groovy.util.logging.Slf4j
import org.springframework.security.access.PermissionEvaluator
import org.springframework.security.core.Authentication

@Slf4j
class CustomPermissionEvaluator implements PermissionEvaluator{

    static final MY_SECURE_TOKEN = 'MY_SECURE_TOKEN'

    @Override
    boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        log.info("Authentication: $authentication, targetDomainObject: $targetDomainObject, permission: $permission")
        targetDomainObject == MY_SECURE_TOKEN
    }

    @Override
    boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false
    }
}
