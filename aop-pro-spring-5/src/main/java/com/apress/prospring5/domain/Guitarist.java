package com.apress.prospring5;

public class Guitarist implements Singer{

	private final String lyric= "You're gonna live forever in me";
	
	@Override
	public void sing() {
		System.out.println(lyric);
	}

}
