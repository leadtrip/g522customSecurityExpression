package wood.mike

import grails.gorm.transactions.Transactional
import org.springframework.security.access.prepost.PreAuthorize

@Transactional
class SecureService {

    /**
     * Restrictions are managed by CustomPermissionEvaluator
     */
    @PreAuthorize("hasPermission('bacon', 'eggs')")
    def teleport() {
        "You're allowed to teleport"
    }

    /**
     * Restrictions are managed by CustomPermissionEvaluator
     */
    @PreAuthorize("hasPermission('MY_SECURE_TOKEN', 'read')")
    def bounce() {
        "You're allowed to bounce"
    }

    /**
     * Restrictions are managed by CustomMethodSecurityExpressionRoot hasCustomMethodPermission()
     */
    @PreAuthorize("hasCustomMethodPermission()")
    def abseil() {
        "You're allowed to do abseil"
    }

    /**
     * Restrictions are managed by CustomMethodSecurityExpressionRoot hasCustomMethodPermission()
     */
    @PreAuthorize("hasCustomMethodPermission()")
    def climb() {
        "You're allowed to climb"
    }

    /**
     * Restrictions are managed by CustomMethodSecurityExpressionRoot hasCustomMethodPermission()
     */
    @PreAuthorize("hasCustomMethodPermission()")
    def fly() {
        "You're allowed to fly"
    }
}
