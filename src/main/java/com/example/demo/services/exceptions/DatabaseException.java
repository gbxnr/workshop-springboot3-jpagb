package com.example.demo.services.exceptions;

public class DatabaseException extends RuntimeException{
    private static final long seriaVersionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }
}
