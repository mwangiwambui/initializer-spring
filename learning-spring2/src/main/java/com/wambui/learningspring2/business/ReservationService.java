    package com.wambui.learningspring2.business;

import java.util.*;


import com.wambui.learningspring2.data.*;
import org.springframework.stereotype.Service;
    @Service

    public class ReservationService {
    private final RoomRespository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

        public ReservationService(RoomRespository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
            this.roomRepository = roomRepository;
            this.guestRepository = guestRepository;
            this.reservationRepository = reservationRepository;
        }

        public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByResDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
        return roomReservations;
    }

    public List<Guest> getHotelGuests(){
            Iterable<Guest> guests = this.guestRepository.findAll();
            List<Guest> guestList = new ArrayList<>();
            guests.forEach(guest -> {guestList.add(guest);});
            guestList.sort(new Comparator<Guest>() {
                @Override
                public int compare(Guest o1, Guest o2) {
                    if (o1.getLastName().equals(o2.getLastName())){
                        return o1.getName().compareTo(o2.getName());
                    }
                    return o1.getLastName().compareTo(o2.getLastName());
                }
            });
            return guestList;
    }

    public List<Room> getRooms(){
            Iterable<Room> rooms = this.roomRepository.findAll();
            List<Room> roomList = new ArrayList<>();
            rooms.forEach(room -> {roomList.add(room);});
            return  roomList;
    }

    public void addGuests(Guest guest){
            Guest newGuest = new Guest();
            newGuest.setName(guest.getName());
            newGuest.setAddress(guest.getAddress());
            newGuest.setCountry(guest.getCountry());
            newGuest.setEmailAddress(guest.getEmailAddress());
            newGuest.setState(guest.getState());
            newGuest.setLastName(guest.getLastName());
            newGuest.setPhoneNumber(guest.getPhoneNumber());
            guestRepository.save(newGuest);
    }



}

