package com.apress.prospring5;

import org.springframework.aop.framework.ProxyFactory;

import com.apress.prospring5.advice.around.ProfilingInterceptor;
import com.apress.prospring5.domain.WorkerBean;

public class ProfilingDemo {

	public static void main(String[] args) {
		WorkerBean bean= getWorkerBean();
		bean.doSomeWork(10000000);
	}
	
	private static WorkerBean getWorkerBean() {
		WorkerBean target= new WorkerBean();
		
		ProxyFactory pf= new ProxyFactory();
		pf.addAdvice(new ProfilingInterceptor());
		pf.setTarget(target);
		
		return (WorkerBean)pf.getProxy(); 
	}
}
