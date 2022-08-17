package wood.mike

import grails.gorm.transactions.Transactional

@Transactional
class ControllerActionPermissionService {

    def isAllowed(String username, String controller, String action) {
        log.info("Username $username controller $controller action $action")
        User user = User.findByUsername(username)
        def perms = ControllerActionPermission.findByUserAndController( user, controller )
        perms ? perms.actions.split(',').contains(action) : false
    }
}
