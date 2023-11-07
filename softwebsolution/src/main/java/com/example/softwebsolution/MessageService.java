package com.example.softwebsolution;

public interface MessageService {

    String getMessage(String id);

    String getMessage(String id, Object[] args);

}