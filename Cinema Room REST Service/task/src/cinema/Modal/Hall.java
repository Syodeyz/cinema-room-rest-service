package cinema.Modal;

import cinema.bootstrap.Bootstrap;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hall {
    @JsonProperty
    public static  int total_rows;
    @JsonProperty
    public static  int total_columns;
    @JsonProperty
    public List<Seat> available_seats = Collections.synchronizedList(new ArrayList<>());;



    public Hall() {
        this.total_rows = 9;
        this.total_columns = 9;


    }

    public static int getTotal_rows() {
        return total_rows;
    }

    public static int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailableSeats() {
        return available_seats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.available_seats = availableSeats;
    }

    public void updateAvailableSeats(Seat seat) {
        Iterator<Seat> iterator = available_seats.iterator();
        while(iterator.hasNext()){
            Seat s = iterator.next();
            if(seat.getColumn() == s.getColumn() && seat.getRow() == s.getRow()) {
                iterator.remove();
            }
        }

    }
}
