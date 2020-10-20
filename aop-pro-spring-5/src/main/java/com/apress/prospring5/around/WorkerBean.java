package com.apress.prospring5.around;

import java.util.stream.IntStream;

public class WorkerBean {
	
	public void doSomeWork(int noOfTimes) {
		IntStream.range(0, noOfTimes)
			.forEach(i -> work());
	}
	
	private void work() {
		System.out.println("");
	}

}
