package com.examen.fullstack.mireia.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examen.fullstack.mireia.exceptions.AutorNotFoundException;



public class GlobalExceptionHandler {
	@ExceptionHandler( AutorNotFoundException.class )
	public ProblemDetail handleAutorNotFoundException(AutorNotFoundException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Autor Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Autor");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
}
