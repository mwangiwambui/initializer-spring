package com.wambui.learningspring2.webservice;

import com.wambui.learningspring2.business.ReservationService;
import com.wambui.learningspring2.business.RoomReservation;
import com.wambui.learningspring2.data.Guest;
import com.wambui.learningspring2.data.Room;
import com.wambui.learningspring2.util.DateUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }
    @RequestMapping(path="/guests", method = RequestMethod.GET)
    public List<Guest> getGuests(){
        return this.reservationService.getHotelGuests();
    }
    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }
    @RequestMapping(path = "/guests", method = RequestMethod.POST)
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest){
        reservationService.addGuests(guest);
        return ResponseEntity.ok().body(guest);
    }

}
