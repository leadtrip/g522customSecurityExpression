import wood.mike.CustomMethodSecurityExpressionHandler
import wood.mike.CustomPermissionEvaluator
import wood.mike.CustomWebSecurityExpressionHandler
import wood.mike.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)

    customePe(CustomPermissionEvaluator)

    expressionHandler(CustomMethodSecurityExpressionHandler){
        permissionEvaluator = ref('customePe')
    }

    webExpressionHandler(CustomWebSecurityExpressionHandler)
}
