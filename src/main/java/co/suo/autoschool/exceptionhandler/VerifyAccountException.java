package co.suo.autoschool.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VerifyAccountException extends RuntimeException {
	public VerifyAccountException(String message) {
		super(message);
	}
}