package com.kodlama.io.bootCampProject;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.ErrorDataResult;

@SpringBootApplication
@RestControllerAdvice
public class BootCampProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCampProjectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors, "VALIDATION EXCAPTION");

		return errorDataResult;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBussinesExcaption(BusinessExcaption businessExcaption) {
		ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(businessExcaption.getMessage(),
				"BUSSINESS EXCEPTION");
		return erroDataResult;
	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorDataResult<Object> handleGeneralhException(InvalidFormatException ex) {
		ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(ex.getMessage(),
				"TYPE EXCEPTION");
		return erroDataResult;

	}
	
	@ExceptionHandler(Exception.class)
	public ErrorDataResult<Object> handleGeneralhException(Exception ex) {
		ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(ex.getMessage(),
				"EXCEPTION");
		return erroDataResult;

	}
//	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//	public ErrorDataResult<Object> handlMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
//	ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(methodArgumentTypeMismatchException.getMessage(),
//			"Method argument  EXCEPTION");
//		return erroDataResult;
//	}



}
