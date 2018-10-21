package com.snkit.hystrix.fallback.hystrixjava;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixCommand.Setter;

public class HystrixDemo {

	public static void main(String args[]) {

	/*	GreetingCommand command = new GreetingCommand("srinu");
		String resp = command.execute();
		System.out.println("   resp  " + resp);*/
		
		
		Setter config	=Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GtreeingCommandKey"))
		.andCommandKey(HystrixCommandKey.Factory.asKey("GreetingCommandKey"))
		.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hystrixThreadpool")).andCommandPropertiesDefaults(
				HystrixCommandProperties.Setter().withCircuitBreakerRequestVolumeThreshold(2)
				.withCircuitBreakerSleepWindowInMilliseconds(1500)
						.withCircuitBreakerEnabled(true).withExecutionTimeoutInMilliseconds(1000));
		
		for (int i = 0; i < 20; i++) {
			GreetingHystrixPropertiesCommand hysPropCommand = new GreetingHystrixPropertiesCommand("srinu",config,new RemoteService());
			String hysPropCommandResp = hysPropCommand.execute();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("   hysPropCommandResp  " + hysPropCommandResp);
		}

	}

}
