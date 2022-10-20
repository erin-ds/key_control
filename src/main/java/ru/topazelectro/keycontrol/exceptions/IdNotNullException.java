package ru.topazelectro.keycontrol.exceptions;

public class IdNotNullException extends RuntimeException {

    private static final String MESSAGE = "Для новой записи id всегда должен быть null";

    public IdNotNullException() {
        super(MESSAGE);
    }
}
