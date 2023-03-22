package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class GeneralAspect {
	
	@Around("execution(* com.example.demo.controller.EmpController.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    long start = System.currentTimeMillis();

	    Object proceed = joinPoint.proceed();

	    long executionTime = System.currentTimeMillis() - start;

	   log.info("******************************::"+joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    return proceed;
	}
	
	 /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
     */
    @AfterThrowing(value =  "execution(* com.example.demo.controller.EmpController.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

}
