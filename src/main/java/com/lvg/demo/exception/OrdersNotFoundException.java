package com.lvg.demo.exception;

public class OrdersNotFoundException extends RuntimeException{
	private String message;
	public OrdersNotFoundException() {
		
	}
	public OrdersNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OrdersNotFoundException [message=" + message + "]";
	}
	

}
