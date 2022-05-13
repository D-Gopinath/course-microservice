package com.ecommerceapp.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger log  = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution (* com.ecommerceapp.controller.CourseController+.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logaround is running");
		System.out.println("Method name:"+ joinPoint.getSignature().getName());
		System.out.println("Method parameters:"+Arrays.toString(joinPoint.getArgs()));
		Object object = joinPoint.proceed();
		System.out.println("logaround is completed");
		return object;
	}
	
}
