package com.neurogine.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import com.neurogine.demo.exphandler.TaskException;

@Aspect
@Configuration
public class AspectConfig {

	private final Logger log = LoggerFactory.getLogger(AspectConfig.class);
	
	@Before(value = "execution(* com.neurogine.demo.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}",joinPoint);
	}
	
	@After(value = "execution(* com.neurogine.demo.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Complete execution of {}",joinPoint);
	}
	
	@Around(value = "execution(* com.neurogine.demo.service.*.*(..))")
	public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try {
			return joinPoint.proceed();
		}
		catch(TaskException e) {
			log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
			log.info("TaskException Message {}",e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}
	
	@Around(value = "execution(* com.neurogine.demo.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime=System.currentTimeMillis();
		
		try {
			long timeTaken=System.currentTimeMillis()-startTime;
			log.info("Time taken by {} is {}",joinPoint,timeTaken);
			return joinPoint.proceed();
		}
		catch(TaskException e) {
			log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
			log.info("TaskException Message {}",e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}
}