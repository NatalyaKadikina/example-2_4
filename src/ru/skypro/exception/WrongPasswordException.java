package ru.skypro.exception;

public class WrongPasswordException extends  RuntimeException{
    public WrongPasswordException(String message) {
        super(message);
    }
}
