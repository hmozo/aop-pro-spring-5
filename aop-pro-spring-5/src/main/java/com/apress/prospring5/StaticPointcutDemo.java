package com.apress.prospring5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.apress.prospring5.advice.SimpleAdvice;
import com.apress.prospring5.domain.GoodGuitarist;
import com.apress.prospring5.domain.GreatGuitarist;
import com.apress.prospring5.domain.Singer;
import com.apress.prospring5.pointcut.SimpleStaticPointcut;

public class StaticPointcutDemo {
	
	public static void main(String[] args) {
		Singer johnMayer= new GoodGuitarist();
		Singer ericClapton= new GreatGuitarist();
		
		Singer proxyOne;
		Singer proxyTwo;
		
		Pointcut pc= new SimpleStaticPointcut();
		Advice advice= new SimpleAdvice();
		Advisor advisor= new DefaultPointcutAdvisor(pc, advice);
		
		ProxyFactory pf= new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(johnMayer);
		proxyOne= (Singer) pf.getProxy();
		
		pf= new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(ericClapton);
		proxyTwo= (Singer) pf.getProxy();
		
		proxyOne.sing();
		proxyTwo.sing();
	}

}
