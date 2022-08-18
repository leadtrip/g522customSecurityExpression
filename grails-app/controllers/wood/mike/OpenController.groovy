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

    /**
     * No restrictions on the controller but there are on the service
     */
    def teleport() {
        redirect( action: 'index', params: [result: secureService.teleport()] )
    }

    /**
     * No restrictions on the controller but there are on the service
     */
    def bounce() {
        redirect( action: 'index', params: [result: secureService.bounce()] )
    }

    /**
     * Restrictions on controller action, see CustomWebSecurityExpressionRoot hasCustomPermission()
     * abseil action is allowed as setup in Bootstrap
     */
    @Secured('hasCustomPermission()')
    def abseil() {
        redirect( action: 'index', params: [result: secureService.abseil()] )
    }

    /**
     * Restrictions on controller action, see CustomWebSecurityExpressionRoot hasCustomPermission()
     * fly action is allowed as setup in Bootstrap
     */
    @Secured('hasCustomPermission()')
    def fly() {
        redirect( action: 'index', params: [result: secureService.fly()] )
    }

    /**
     * Restrictions on controller action, see CustomWebSecurityExpressionRoot hasCustomPermission()
     * climb action isn't allowed, not setup in Bootstrap
     */
    @Secured('hasCustomPermission()')
    def climb() {
        redirect( action: 'index', params: [result: secureService.climb()] )
    }
}
