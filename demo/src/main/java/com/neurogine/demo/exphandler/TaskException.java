package com.neurogine.demo.exphandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class TaskException extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;
	
	
	public TaskException(String message) {
		super();
		this.message = message;
	}

}
