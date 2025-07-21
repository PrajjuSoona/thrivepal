package com.thrivepal.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorResponse {
	private String message;
	private String errorCode;
	private int status;

	public ErrorResponse(String message, String errorCode, int status) {
		this.message = message;
		this.errorCode = errorCode;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
