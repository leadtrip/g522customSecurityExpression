package wood.mike

import grails.gorm.transactions.Transactional
import org.springframework.security.access.prepost.PreAuthorize

@Transactional
class SecureService {

    //@PreAuthorize("hasPermission('bacon', 'eggs')")
    def teleport() {
        "You're allowed to teleport"
    }

    //@PreAuthorize("hasPermission('MY_SECURE_TOKEN', 'read')")
    def bounce() {
        "You're allowed to bounce"
    }

    //@PreAuthorize("hasShiroPerms()")
    def doShiro() {
        "You're allowed to do shiro stuff"
    }
}
