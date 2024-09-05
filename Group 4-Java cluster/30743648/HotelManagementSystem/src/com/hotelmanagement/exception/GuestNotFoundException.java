package com.hotelmanagement.exception;

@SuppressWarnings("serial")
public class GuestNotFoundException extends Exception {
    public GuestNotFoundException(String message) {
        super(message);
    }
}
