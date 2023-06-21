package com.becoder.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMsg {

	private String msg;

	private HttpStatus status;

	private Boolean success;

}
