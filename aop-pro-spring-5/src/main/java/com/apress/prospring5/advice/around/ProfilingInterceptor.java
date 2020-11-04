package com.apress.prospring5.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ProfilingInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch sw= new StopWatch();
		sw.start(invocation.getMethod().getName());
		Object returnValue= invocation.proceed();
		sw.stop();
		dumpInfo(invocation, sw.getTotalTimeMillis());
		
		return returnValue;
	}
	
	private void dumpInfo(MethodInvocation invocation, long ms) {
		Method method= invocation.getMethod();
		Object target= invocation.getThis();
		Object[] args= invocation.getArguments();
		
		System.out.println("Executed method: " + method.getName());
		System.out.println("On object of type: " + target.getClass().getName());
		System.out.println("With arguments:");
		Arrays.stream(args).forEach(a -> System.out.println("       " + a));
		System.out.println("\n");
		System.out.println("Took: " + ms + " ms");
	}
	

}
