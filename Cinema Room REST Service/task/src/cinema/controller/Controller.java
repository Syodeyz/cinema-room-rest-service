package cinema.controller;

import cinema.Modal.*;
import cinema.bootstrap.Bootstrap;
import cinema.exceptions.AlreadyPurchasedException;
import cinema.exceptions.RowOrColumnOutOfBoundsException;
import cinema.exceptions.WrongPasswordException;
import cinema.exceptions.WrongTokenException;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
public class Controller {

    public Hall hall = new Hall();
    public Bootstrap bootstrap = new Bootstrap(hall);
    public Map<String, Object> mapOfHall = new HashMap<>();




    @GetMapping("/seats")
    public Map<String, Object> fetchSeats() {
        mapOfHall.put("total_rows", Hall.getTotal_rows());
        mapOfHall.put("total_columns", Hall.getTotal_columns());
        mapOfHall.put("available_seats", hall.getAvailableSeats());
        return mapOfHall;
    }

    @PostMapping("/purchase")
    public Map<String, Object> postSeatPurchase(@RequestBody Seat seat) {
        // check if the given seat is available
        //System.out.println("row " + seat.getRow() + " col " + seat.getColumn());
        List<Seat> availableSeats = hall.getAvailableSeats();
        List<BookedSeat> bookedSeats = bootstrap.getBookedSeats();
            if(seat.getRow() <= 0
                    || seat.getRow() > 9
                    || seat.getColumn()  <= 0
                    || seat.getColumn() > 9
            ) {
                throw new RowOrColumnOutOfBoundsException();

            } else {
                for(Seat s : availableSeats) {
                    if(s.getRow() == seat.getRow() && s.getColumn() == seat.getColumn()) {
                        //System.out.println("booked row " + s.getRow() + " booked col " + s.getColumn());
                        BookedSeat bookedSeat = new BookedSeat(seat.getRow(), seat.getColumn());
                        bookedSeats.add(bookedSeat);
                        // update availableSeat
                        hall.updateAvailableSeats(seat);
                        return Map.of("token", bookedSeat.getToken(),
                                "ticket", seat
                        );
                    }
                }
                throw new AlreadyPurchasedException();
            }
    }

    @PostMapping("/return")
    public Map<String, Seat> refundSeat(@RequestBody Token token) {
        /**
         * go through booked ticket
         * see if the token exist
         * if yes -> remove the booked seat from booked seat
         * if no -> return error
         * */

        List<BookedSeat> bookedSeats = bootstrap.getBookedSeats();
        String givenToken = token.getToken();
        for(BookedSeat bookedSeat : bookedSeats) {
            String bookedToken = bookedSeat.getToken();
            //System.out.println(" given token " + token + " booked token " + bookedToken);
            if(bookedToken.equals(givenToken)) {
                Seat refundSeat = new Seat(bookedSeat.getRow(), bookedSeat.getColumn());
                hall.getAvailableSeats().add(refundSeat);
                bootstrap.updateBookedSeats(givenToken);
                return Map.of("returned_ticket", refundSeat);
            }
        }
        throw new WrongTokenException();

    }

    @PostMapping("/stats")
    public Stats getStats(@RequestParam(required = false) String password) {
        System.out.println("password " + password);
        if(password != null && password.equals("super_secret")) {
            // find the length of booked seats list
            bootstrap.updateStats();
            return Bootstrap.stats;
        } else {
            throw new WrongPasswordException();
        }
    }
}
