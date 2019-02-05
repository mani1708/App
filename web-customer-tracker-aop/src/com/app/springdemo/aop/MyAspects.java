package com.app.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {
	
	@Pointcut("execution(* com.app.springdemo.dao.*.*(..))")
	public void pointcutForDAO() {
		
	}

	@Before("pointcutForDAO()")
	public void beforeDAOPackage(JoinPoint theJoinPoint) {
		
		
		String methodSignature=theJoinPoint.getSignature().toShortString();
		System.out.println("@Before: Dao method invoked"+ methodSignature);
		
		Object args[]=theJoinPoint.getArgs();
		
		for(Object obj:args) {
			System.out.println("@Before "+methodSignature+ "Method Arguments "+obj);
		}
		
		
	}
	
	@Around("execution(* com.app.springdemo.dao.CustomerDAOImpl.saveCustomer(..))")
	public void afterReturningDAOPackage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		Long startTime=System.currentTimeMillis();
		
		Object result=proceedingJoinPoint.proceed();
		
		Long endTime=System.currentTimeMillis();
		
		Long diff=(endTime-startTime)/10;
		
		System.out.println("Execution time :"+diff);
		
		
		
		
		
		
	}
}
