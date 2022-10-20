package ru.topazelectro.keycontrol.exceptions;

public class SoftwareAlreadyExistException extends RuntimeException{

    private static final String MESSAGE = "Такой тип ПО уже существует";

    public SoftwareAlreadyExistException() {
        super(MESSAGE);
    }
}
