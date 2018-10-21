package com.snkit.hystrix.fallback.hystrixjava;

import com.netflix.hystrix.HystrixCommand;

public class GreetingHystrixPropertiesCommand extends HystrixCommand<String> {

	String username;

	RemoteService rService;

	long startTime;

	protected GreetingHystrixPropertiesCommand(String input, Setter config, RemoteService rService) {

		super(config);

		this.username = input;
		this.rService = rService;

		startTime = System.currentTimeMillis();

	}

	@Override
	protected String run() throws Exception {
		return this.rService.sayHi(this.username);
	}

	protected String getFallback() {

		long sysTime = System.currentTimeMillis();

		System.out.println("  Time taken to processs ========================= " + (sysTime - startTime));

		return "No remote resouce avaibale ";
	}
}
