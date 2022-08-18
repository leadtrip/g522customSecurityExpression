package wood.mike

import grails.gorm.transactions.Transactional

@Transactional
class ControllerActionPermissionService {

    /**
     * @param username      - logged in user username
     * @param controller    - controller being accessed
     * @param action        - action being accessed
     * @return true if the user has permission to access the controller action
     */
    def isAllowed(String username, String controller, String action) {
        log.info("Username $username controller $controller action $action")
        User user = User.findByUsername(username)
        def perms = ControllerActionPermission.findByUserAndController( user, controller )
        perms ? perms.actions.split(',').contains(action) : false
    }
}
