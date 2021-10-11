package com.latewind.bootstart.log;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class WebLogAspect {

	/**
	 * 横切点
	 */
	@Pointcut("execution(public * com.latewind.bootstart.info.controller..*.*(..))")
	public void webLog() {

	}

	@Pointcut("execution(public * com.latewind.bootstart.portal.PortalController.helloBoot(..))")
	public void hello() {

	}

	/**
	 * 通知 before
	 * 
	 * @param point
	 */
	@Before(value = "webLog()")
	public void doBefore(JoinPoint point) {
		Class<? extends Object> targetClass = point.getTarget().getClass();
		String methodName = point.getSignature().getName();

		Logger log = LoggerFactory.getLogger(targetClass);
		log.debug("start method {}", methodName);
	}

	/**
	 * 通知 after
	 * 
	 * @param point
	 * @param ret
	 * @throws Throwable
	 */
	@AfterReturning(value = "webLog()", returning = "ret")
	public void doAfterReturning(JoinPoint point, Object ret) throws Throwable {

		Class<? extends Object> targetClass = point.getTarget().getClass();
		String methodName = point.getSignature().getName();

		Logger log = LoggerFactory.getLogger(targetClass);
		log.debug("end method {}", methodName);
	}

	/**
	 * 修改返回结果
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "hello()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object originRet = proceedingJoinPoint.proceed();

		LoggerFactory.getLogger(WebLogAspect.class).debug("origin return is : {}", originRet);
		
		return "hello boot";
	}

}
