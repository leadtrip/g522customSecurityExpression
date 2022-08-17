This project uses spring security with custom
 
* MethodSecurityExpressionHandler
* MethodSecurityExpressionRoot
* WebSecurityExpressionHandler
* WebSecurityExpressionRoot
* PermissionEvaluator

The goal is to use custom expressions in both controllers and services to restrict access based on whatever you want.

The CustomPermissionEvaluator is the least flexible as you're tied to the arguments demanded by the 2 x methods in PermissionEvaluator

By extending SecurityExpressionRoot we can add methods that can then be used as expressions in annotations such
as @PreAuthorize in services

By extending WebSecurityExpressionRoot we can add methods that can be used as expressions in annotations such ad
@Secured in controllers