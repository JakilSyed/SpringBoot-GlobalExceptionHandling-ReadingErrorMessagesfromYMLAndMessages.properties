package com.jakil.EMS.Exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jakil.EMS.utils.ErrorMessageFromMessageProperties;
import com.jakil.EMS.utils.ErrorTypeFromYML;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	ErrorTypeFromYML errorMessageFromYML;

	@Autowired
	ErrorMessageFromMessageProperties errorMessageFromMessageProperties;

	@ExceptionHandler(EMSException.class)
	public ResponseEntity<EMSExceptionResponse> exceptionHandler(EMSException ex) {

		EMSExceptionResponse response = new EMSExceptionResponse();
		response.setCode(ex.getCode());
		response.setExceptionType(errorMessageFromYML.getErrorTypeFromYML(ex.getCode()));
		response.setErrorMessage(errorMessageFromMessageProperties.getMessageFromMessageProp(ex.getCode()));
		response.setDate(new Date());

		return new ResponseEntity<EMSExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
}
