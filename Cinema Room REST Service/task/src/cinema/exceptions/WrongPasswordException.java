package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "The password is wrong!")
public class WrongPasswordException extends RuntimeException {
    private String error;
    public WrongPasswordException() {
        super();
        this.error = "The password is wrong!";
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
