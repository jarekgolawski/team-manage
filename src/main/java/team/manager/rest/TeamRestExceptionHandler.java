package team.manager.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeamRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<TeamErrorResponse> handleException (TeamNotFoundException exc) {
		TeamErrorResponse error = new TeamErrorResponse(
									HttpStatus.NOT_FOUND.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<TeamErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<TeamErrorResponse> handleException (Exception exc) {
		TeamErrorResponse error = new TeamErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<TeamErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
