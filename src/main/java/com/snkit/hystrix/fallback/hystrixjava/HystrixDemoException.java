package com.snkit.hystrix.fallback.hystrixjava;

public class HystrixDemoException extends RuntimeException {
	
	String msg;
	HystrixDemoException(String msg){
		
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
