package online.advertisement.system.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

//	when a CategoryNotFoundException is thrown, then this method is used to catch
	@ExceptionHandler(CategoryNotFoundException.class)
	
	public final ResponseEntity<Object> handleCategoryNotFoundException() {
		LOG.error("handleCategoryNotFoundException");

		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
		

	}

}
