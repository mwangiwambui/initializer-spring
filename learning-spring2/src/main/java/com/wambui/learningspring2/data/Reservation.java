package com.wambui.learningspring2.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RESERVATION_ID")
    private long reservationId;
    @Column(name="ROOM_ID")
    private long roomId;
    @Column(name="GUEST_ID")
    private String guestId;
    @Column(name="RES_DATE")
    private Date resDate;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", roomId=" + roomId +
                ", guestId='" + guestId + '\'' +
                ", resDate=" + resDate +
                '}';
    }
}
