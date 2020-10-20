package com.apress.prospring5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
	
	public static void main(String[] args) {
		SecurityManager mgr= new SecurityManager();
		
		SecureBean bean= getSecureBean();
		
		mgr.login("John", "pwd");
		bean.writeSecureMessage();
		mgr.logout();
		
		try {
			mgr.login("invalid user", "pwd");
			bean.writeSecureMessage();
		}catch(SecurityException ex) {
			System.out.println("Exception caugth: " + ex.getMessage());
		}finally {
			mgr.logout();
		}
		
	}
	
	private static SecureBean getSecureBean() {
		SecureBean target= new SecureBean();
		
		SecurityAdvice advice= new SecurityAdvice();
		
		ProxyFactory factory= new ProxyFactory();
		factory.addAdvice(advice);
		factory.setTarget(target);
		
		SecureBean proxy= (SecureBean) factory.getProxy();
		
		return proxy;
	}

}
