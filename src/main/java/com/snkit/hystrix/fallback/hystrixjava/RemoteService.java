package com.snkit.hystrix.fallback.hystrixjava;

public class RemoteService {

	
	public String sayHi(String username) {
		
	
	
	 if (username.contains("demo") ) {
		 throw new HystrixDemoException("  To test Hystrix throwing exception");
	 }
	 
	 try {
		Thread.sleep(999);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		return "Hi Welcome Hystrix "+username;
	}
}
