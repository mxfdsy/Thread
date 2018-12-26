package enjoy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//日志切面类
@Aspect
public class LogAspects {

    @Pointcut("execution(public int enjoy.aop.Calculator.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("start...log" + "method name " + joinPoint.getSignature().getName() + "   args list is "
        + Arrays.asList(joinPoint.getArgs()));
    }

    //无论在方法正常结束，还是异常结束都会执行
    @After("enjoy.aop.LogAspects.pointCut()")
    public void logEnd() {
        System.out.println("end...log");

    }

    @AfterReturning(value = "enjoy.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn (Object result) {
        System.out.println("return....log  result is "+ result);
    }


    @AfterThrowing(value = "enjoy.aop.LogAspects.pointCut()", throwing = "exception")
    public void logException(Exception exception){
        System.out.println("AfterThrowing .......  exception is" + exception);
    }

    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{


        System.out.println("@Arount:Execution method... before");
        Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
        System.out.println("@Arount:Execution method... after");
        return obj;
    }
}