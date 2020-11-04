package com.apress.prospring5.advice.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import com.apress.prospring5.domain.Guitarist;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	
	public static void main(String[] args) {
		Guitarist johnMayer= new Guitarist();
		
		ProxyFactory pf= new ProxyFactory();
		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(johnMayer);
		
		Guitarist proxy= (Guitarist) pf.getProxy();
		proxy.sing();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Before '" + method.getName() + "', tune guitar" );
		
	}

}
