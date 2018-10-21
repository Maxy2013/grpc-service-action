package com.lz.grpcservice.config.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParamsInterceptor {

    @Pointcut("execution(* com.lz.grpcservice.module.payment.web.PaymentGrpcServerService.payment(..))")
    public void paramsPointCut(){}

    @Before("paramsPointCut()")
    public void doBefore(){
//        String name = joinPoint.getStaticPart().getSignature().getName();
        System.out.println("------->>>>>拦截前");

    }


    @After("paramsPointCut()")
    public void doAfter(){
//        String name = joinPoint.getStaticPart().getSignature().getName();
        System.out.println("------->>>>>拦截后<<<<<--------");

    }
}
