package cinema.Modal;

import java.util.ArrayList;
import java.util.List;

public class AvailableSeat extends Seat{
    public boolean available;
    public List<Seat> availableSeats = new ArrayList<>();


    public AvailableSeat(int row, int col, boolean available) {
       super(row, col);
       this.available = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean available() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
