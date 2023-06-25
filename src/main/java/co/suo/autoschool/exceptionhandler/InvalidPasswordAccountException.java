package co.suo.autoschool.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPasswordAccountException extends RuntimeException {
	public InvalidPasswordAccountException(String message) {
		super(message);
	}
}