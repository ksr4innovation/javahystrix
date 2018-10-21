package com.snkit.hystrix.fallback.hystrixjava;

public class DemoSingletonIncrementer {
	
	public static Integer count = new Integer(0);

	
	public static Integer getCount() {
		count = count+1;
		return count;
	}
}
