package wood.mike

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = {
        addTestUsers()
    }

    @Transactional
    void addTestUsers() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def user1 = new User(username: 'user1', password: 'password').save()
        def user2 = new User(username: 'user2', password: 'password').save()

        UserRole.create user1, adminRole
        UserRole.create user2, adminRole

        new ControllerActionPermission(user: user1, controller: 'open', actions: 'abseil,fly' ).save()
    }

    def destroy = {
    }
}
