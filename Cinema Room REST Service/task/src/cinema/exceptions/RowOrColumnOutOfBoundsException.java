package cinema.exceptions;

import io.micrometer.core.instrument.MultiGauge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The number of a row or a column is out of bounds!")
public class RowOrColumnOutOfBoundsException extends RuntimeException{
    public String error;
    public RowOrColumnOutOfBoundsException() {
        super();
        this.error = "The number of a row or a column is out of bounds!";

    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
