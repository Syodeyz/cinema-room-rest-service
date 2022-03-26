package cinema.Modal;

import java.util.UUID;

public class BookedSeat extends Seat{
    private String token;

    public BookedSeat(int row, int column){
        super(row, column);
        this.token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }
}
