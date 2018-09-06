package team.manager.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class PlayerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PlayerErrorResponse> handleException (PlayerNotFoundException exc) {
		PlayerErrorResponse error = new PlayerErrorResponse(
									HttpStatus.NOT_FOUND.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<PlayerErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PlayerErrorResponse> handleException (Exception exc) {
		PlayerErrorResponse error = new PlayerErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<PlayerErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
