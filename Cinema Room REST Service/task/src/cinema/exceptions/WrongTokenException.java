package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Wrong token!")
public class WrongTokenException extends RuntimeException {
        private String error;

        public WrongTokenException() {
            super();
            this.error = "Wrong token!";
        }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
