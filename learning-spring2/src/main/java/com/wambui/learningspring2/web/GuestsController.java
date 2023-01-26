package com.wambui.learningspring2.web;

import com.wambui.learningspring2.business.ReservationService;
import com.wambui.learningspring2.data.Guest;
import com.wambui.learningspring2.data.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping("/guests")
public class GuestsController {
    private final ReservationService reservationService;

    public GuestsController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        model.addAttribute("guests", this.reservationService.getHotelGuests());
        return "hotel-guests";
    }
}
