package com.apress.prospring5;

import java.util.stream.IntStream;

import org.springframework.aop.framework.ProxyFactory;

import com.apress.prospring5.advice.after.WeakKeyCheckAdvice;
import com.apress.prospring5.tools.KeyGenerator;

public class AfterAdviceDemo {
	
	
	
	public static void main(String... args) {
		
		KeyGenerator keyGen= getKeyGenerator();
		
		IntStream.range(0, 10)
			.boxed().forEach(x -> {
				try {
					long key= keyGen.getKey();
					System.out.println("Key: " + key);
				}catch(SecurityException ex) {
					System.out.println("Weak key generated!");
				}
			});
		
	}

	private static KeyGenerator getKeyGenerator() {
		KeyGenerator target= new KeyGenerator();
		
		ProxyFactory pf =new ProxyFactory();
		pf.addAdvice(new WeakKeyCheckAdvice());
		pf.setTarget(target);
		
		return (KeyGenerator)pf.getProxy();
	}
}
