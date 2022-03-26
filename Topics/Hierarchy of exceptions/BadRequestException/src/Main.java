import java.text.ParseException;
import java.util.prefs.BackingStoreException;

// update the class
class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}