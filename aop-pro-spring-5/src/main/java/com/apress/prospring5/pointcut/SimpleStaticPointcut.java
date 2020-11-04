package com.apress.prospring5.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.apress.prospring5.domain.GoodGuitarist;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut{

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return ("sing".equals(method.getName()));
	}
	
	@Override
	public ClassFilter getClassFilter() {
		return cls -> (cls == GoodGuitarist.class);
	}

}
