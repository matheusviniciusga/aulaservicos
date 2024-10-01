package com.apirickmorty.demo.exception;

public class LocationNotFoundException extends Exception {
    
    public LocationNotFoundException(String msg) {
        super(msg);
    }

    public LocationNotFoundException(String msg, Long id) {
        super(msg + id);
    }
}
