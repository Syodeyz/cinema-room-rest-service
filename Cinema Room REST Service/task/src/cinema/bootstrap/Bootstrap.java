package cinema.bootstrap;

import cinema.Modal.*;

import java.util.*;

public class Bootstrap {

    public static Stats stats;
    List<Seat> seatsList = new ArrayList();
    List<AvailableSeat> availableSeats = Collections.synchronizedList(new ArrayList<>());
    List<Seat> seatsWithPrice = Collections.synchronizedList(new ArrayList<>());
    List<BookedSeat> bookedSeats =  Collections.synchronizedList(new ArrayList<>());

    public Bootstrap( Hall hall){
        createAvailableSeats(hall);
        filterAvailableSeats();
        hall.setAvailableSeats(seatsWithPrice);
        this.stats = new Stats();
    };

    public void createAvailableSeats(Hall hall) {
        for(int i = 1; i <= hall.getTotal_rows(); i++) {
            for(int j = 1; j <= hall.getTotal_columns(); j++) {
                availableSeats.add(new AvailableSeat(i, j, true));
            }
        }
    }

    /**
     * method to select all seats that are in availabe seats
     * */
    public void filterAvailableSeats(){
        for(AvailableSeat seat : availableSeats) {
            if(seat.available()){
                seatsWithPrice.add(new Seat(seat.getRow(), seat.getColumn()));
            }
        }
    }

    public List<BookedSeat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<BookedSeat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    /**
     * method to update the list of booked list
     */
    public void updateBookedSeats(String token) {
        Iterator<BookedSeat> iterator = bookedSeats.iterator();
        while(iterator.hasNext()){
            BookedSeat s = iterator.next();
            if(token.equals(s.getToken())) {
                iterator.remove();
            }
        }
    }

    /**
     * method to update the stats
     * */
    public void updateStats(){
        int numberOfPurchasedSeats = this.getBookedSeats().size();
        int numberOfAvailableSeats = this.availableSeats.size() - numberOfPurchasedSeats;
        stats.setNumber_of_purchased_tickets(numberOfPurchasedSeats);
        stats.setNumber_of_available_seats(numberOfAvailableSeats);
        int income = 0;
        for(BookedSeat bookedSeat: bookedSeats) {
            income += bookedSeat.getRow() <= 4 ? 10 : 8;
        }
        stats.setCurrent_income(income);
    }

    public List<Seat> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seat> seatsList) {
        this.seatsList = seatsList;
    }

    public List<AvailableSeat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<AvailableSeat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
