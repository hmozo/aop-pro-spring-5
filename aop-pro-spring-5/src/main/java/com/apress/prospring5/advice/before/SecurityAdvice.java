package com.apress.prospring5.advice.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.apress.prospring5.SecurityManager;
import com.apress.prospring5.domain.UserInfo;

public class SecurityAdvice implements MethodBeforeAdvice{

	private final SecurityManager securityManager;
	
	public SecurityAdvice() {
		this.securityManager= new SecurityManager();
	}
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		UserInfo user= securityManager.getLoggedOnUser();
		
		if(user == null) {
			System.out.println("User not authenticated");
			
			throw new SecurityException("Login before invoking the method: "
					+ method.getName());
		}else if("John".equals(user.getUserName())) {
			System.out.println("Logged in user is John - OK");
		}else {
			System.out.println("Logger in user is " + user.getUserName()
					+ " NOT GOOD :(");
			throw new SecurityException("User " + user.getUserName()
					+ " is not allowed access to method " + method.getName());
		}
	}

}
