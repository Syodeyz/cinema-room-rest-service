package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The ticket has been already purchased!")
public class AlreadyPurchasedException extends RuntimeException{
    private String error;
    public AlreadyPurchasedException() {
        super();
        this.error = "The ticket has been already purchased!";
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
