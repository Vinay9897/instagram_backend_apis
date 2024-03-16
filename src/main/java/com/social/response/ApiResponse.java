package com.social.response;

public class ApiResponse {
	
	private Boolean status;
	private String message;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ApiResponse [status=" + status + ", message=" + message + "]";
	}
	
	public ApiResponse(Boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
