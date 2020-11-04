package com.apress.prospring5.advice.after;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import com.apress.prospring5.domain.Guitarist;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice{
	public static void main(String... args) {
		Guitarist target= new Guitarist();
		
		ProxyFactory pf= new ProxyFactory();
		pf.addAdvice(new SimpleAfterReturningAdvice());
		pf.setTarget(target);
		
		Guitarist proxy= (Guitarist) pf.getProxy();
		proxy.sing();
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After '" + method.getName() + "' put down guitar");
	}

}
