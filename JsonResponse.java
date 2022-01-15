package com.apis.employees.response;

import org.springframework.http.HttpStatus;

public class JsonResponse 
{
	private String message;
	
	private HttpStatus Httpstatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpstatus() {
		return Httpstatus;
	}

	public void setHttpstatus(HttpStatus httpstatus) {
		Httpstatus = httpstatus;
	}

	@Override
	public String toString() {
		return "JsonResponse [message=" + message + ", Httpstatus=" + Httpstatus + "]";
	}

	public JsonResponse(String message, HttpStatus httpstatus) {
		super();
		this.message = message;
		Httpstatus = httpstatus;
	}

	

}
