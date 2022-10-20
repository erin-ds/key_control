package ru.topazelectro.keycontrol.exceptions;

public class IdNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Id не найден";

    public IdNotFoundException() {
        super(MESSAGE);
    }
}
