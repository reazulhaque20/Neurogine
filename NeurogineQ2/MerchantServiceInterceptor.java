package com.neurogine.test;

@Aspect
@Component
public class MerchantServiceInterceptor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantServiceInterceptor.class);

    @Before("execution(* com.neurogine.test.MerchantService.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        LOGGER.info("Method {} called with args {}", methodName, args);
    }

    @AfterThrowing(pointcut = "execution(* com.neurogine.test.MerchantService.*(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.error("Exception thrown from method {}: {}", methodName, ex.getMessage());
    }

}
