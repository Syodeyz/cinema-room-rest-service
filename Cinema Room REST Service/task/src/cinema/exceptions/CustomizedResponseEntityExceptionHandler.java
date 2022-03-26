package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlreadyPurchasedException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(AlreadyPurchasedException ex){
        ExceptionResponse exception = new ExceptionResponse(ex.getError());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RowOrColumnOutOfBoundsException.class)
    public final ResponseEntity<ExceptionResponse> rowOrColumnNotFoundException(RowOrColumnOutOfBoundsException ex){
        ExceptionResponse exception = new ExceptionResponse(ex.getError());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(WrongTokenException.class)
    public final ResponseEntity<ExceptionResponse> rowOrColumnNotFoundException(WrongTokenException ex){
        ExceptionResponse exception = new ExceptionResponse(ex.getError());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public final ResponseEntity<ExceptionResponse> rowOrColumnNotFoundException(WrongPasswordException ex){
        ExceptionResponse exception = new ExceptionResponse(ex.getError());
        return new ResponseEntity<>(exception, HttpStatus.UNAUTHORIZED);
    }


}
