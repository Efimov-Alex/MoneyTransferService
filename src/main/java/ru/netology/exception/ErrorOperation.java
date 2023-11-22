package ru.netology.exception;

public class ErrorOperation extends RuntimeException{
    public ErrorOperation(String msg){
        super(msg);
    }
}
