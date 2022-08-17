package wood.mike

import grails.plugin.springsecurity.annotation.Secured
import grails.web.Action

@Secured('permitAll')
class OpenController {

    def secureService

    def index() {
        def actions =
            getClass().methods.toList()
                .stream()
                .filter(m -> m.getAnnotation(Action) != null)
                .map(m-> m.name)

        [actions: actions, result: params.result]
    }

    def teleport() {
        redirect( action: 'index', params: [result: secureService.teleport()] )
    }

    def bounce() {
        redirect( action: 'index', params: [result: secureService.bounce()] )
    }

    @Secured('hasShiroPerms()')
    def abseil() {
        redirect( action: 'index', params: [result: secureService.doShiro()] )
    }

    @Secured('hasShiroPerms()')
    def fly() {
        redirect( action: 'index', params: [result: secureService.doShiro()] )
    }

    @Secured('hasShiroPerms()')
    def climb() {
        redirect( action: 'index', params: [result: secureService.doShiro()] )
    }
}
