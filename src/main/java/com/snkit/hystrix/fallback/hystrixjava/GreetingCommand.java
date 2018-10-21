package com.snkit.hystrix.fallback.hystrixjava;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GreetingCommand extends HystrixCommand<String> {
	
	String username;

	protected GreetingCommand(String input) {
		super(HystrixCommandGroupKey.Factory.asKey("GtreeingCommandKey"));
		this.username = input;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String run() throws Exception {
		
		System.out.println(" From run method =========================  ");
		RemoteService rService = new RemoteService();
		
		return rService.sayHi(this.username);
	}

	
	 protected String getFallback() {
		 
		 return "No remote resouce avaibale ";
	 }
}
