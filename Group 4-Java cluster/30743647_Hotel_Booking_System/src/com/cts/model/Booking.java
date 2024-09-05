package com.cts.model;

import java.sql.Date;

import java.sql.Date;

public class Booking {
    private int bookingId;
    private int roomId;
    private int customerId;
    private java.sql.Date checkInDate;
    private java.sql.Date checkOutDate;

    public Booking(int roomId, int customerId, java.sql.Date checkInDate, java.sql.Date checkOutDate) {
        super();
        this.roomId = roomId;
        this.customerId = customerId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public java.sql.Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(java.sql.Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public java.sql.Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(java.sql.Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", roomId=" + roomId + ", customerId=" + customerId
                + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
    }
}

