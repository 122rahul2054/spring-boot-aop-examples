//package com.qspider.AopDemoExample.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//
////    @Before("execution(* com.qspider.AopDemoExample.service.StudentService.createStudent(..))")
////    public void logBeforeMethod(JoinPoint joinPoint) {
////
////        System.out.println("Student is going to be saved");
////
////        Object[] arr = joinPoint.getArgs();
////
////        System.out.println("Method arguments count: " + arr.length);
////
////        boolean allowed = true;
////
////        if (!allowed) {
////            throw new RuntimeException(
////                    "Method execution not allowed"
////            );
////        }
////
////        System.out.println("Method execution is allowed");
////    }
//
//    @After("execution(* com.qspider.AopDemoExample.service.StudentService.createStudent(..))")
//    public void logAfterMethod(JoinPoint joinPoint) {
//
//        System.out.println("Student method execution completed");
//        System.out.println("Method name: "
//                + joinPoint.getSignature().getName());
//    }
//}

package com.qspider.AopDemoExample.aspect;

import com.qspider.AopDemoExample.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @AfterReturning(
//            pointcut = "execution(* com.qspider.AopDemoExample.service.StudentService.createStudent(..))",
//            returning = "result"
//    )
//    public void logAfterReturning(JoinPoint joinPoint, Object result) {
//
//        System.out.println("Student method executed successfully");
//
//        System.out.println(
//                "Method name: " + joinPoint.getSignature().getName()
//        );
//
//        System.out.println("Returned object: " + result);
//    }
//
//    @Around("execution(* com.qspider.AopDemoExample.service.StudentService.createStudent(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint)
//            throws Throwable {
//
//        System.out.println("Before method execution");
//
//        // Execute the actual service method
//        Student result = (Student) joinPoint.proceed();
//        result.setName("Ankush");
//        result.setAge(18);
//
//        System.out.println("After method execution");
//        System.out.println("Returned value: " + result);
//
//        return result;
//    }

//    @AfterThrowing(
//            pointcut = "execution(* com.qspider.AopDemoExample.service.StudentService.createStudent(..))",
//            throwing = "ex"
//    )
//    public void logAfterThrowing(Exception ex) {
//
//        System.out.println("Exception occurred in createStudent()");
//        System.out.println("Error message: " + ex.getMessage());
//    }

//    @AfterThrowing(
//            pointcut = "execution(* com.qspider.AopDemoExample.service.StudentService.dummyMethod(..))",
//            throwing = "ex"
//    )
//    public void logDummyMethodException(Exception ex) {
//
//        System.out.println("Exception occurred in dummyMethod()");
//        System.out.println("Error message: " + ex.getMessage());
//    }

    @Around(
            "execution(* com.qspider.AopDemoExample.service.StudentService.dummyMethod(..))"
    )
    public Object logAroundMethod(ProceedingJoinPoint joinPoint)
            throws Throwable {

        // First method execution
        Object return1 = joinPoint.proceed();

        System.out.println("First returned value: " + return1);
        System.out.println("Intercepted request, calling again");

        // Second method execution
        Object return2 = joinPoint.proceed();

        System.out.println("Second returned value: " + return2);

        return return2;
    }
}

