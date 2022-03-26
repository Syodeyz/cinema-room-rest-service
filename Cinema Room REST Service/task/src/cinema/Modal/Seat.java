package cinema.Modal;

public class Seat {
    public int row;
    public int column;
    public int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = this.row <= 4 ? 10 : 8;
    }

    //getters and setters
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
}
