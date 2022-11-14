package ru.topazelectro.keycontrol.exceptions;

public class EmptyOrNonExistingIdException extends RuntimeException {

    private static final String MESSAGE = "Передан несуществующий ID или переданный id = null";

    public EmptyOrNonExistingIdException() {
        super(MESSAGE);
    }
}
