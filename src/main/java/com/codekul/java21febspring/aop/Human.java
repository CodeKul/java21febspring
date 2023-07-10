package com.codekul.java21febspring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class Human {

//    @After(value = "pointCut()")
//    public void test() {
//        System.out.println("In Aspect after");
//    }
//
//    @Before(value = "pointCut()")
//    public void test1() {
//        System.out.println("In Aspect before");
//    }

    @Pointcut("execution(* com.codekul.java21febspring.aop.Boy.*(..))")
    public void pointCut() {
    }

    @AfterReturning(value = "pointCut()",returning = "value")
    public void test2(int value) {
        System.out.println("In Aspect after"+value);
    }


}
