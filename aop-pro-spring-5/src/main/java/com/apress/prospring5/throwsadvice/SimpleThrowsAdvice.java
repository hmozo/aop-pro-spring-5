package com.apress.prospring5.throwsadvice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleThrowsAdvice implements ThrowsAdvice{

	public static void main(String[] args) {
		ErrorBean errorBean= new ErrorBean();
		
		ProxyFactory pf= new ProxyFactory();
		pf.addAdvice(new SimpleThrowsAdvice());
		pf.setTarget(errorBean);
		
		ErrorBean proxy= (ErrorBean) pf.getProxy();
		try {
			proxy.otherErrorProneMethod();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	public void afterThrowing(Exception ex) throws Throwable{
		System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("***\n");
	}
	
	public void afterThrowing(Method method, Object args, Object target,
			IllegalArgumentException ex) throws Throwable{
		System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        System.out.println("Caught: " + ex.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
	}
	
	

}
