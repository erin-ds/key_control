package ru.topazelectro.keycontrol.exceptions;

public class EndUserNotExistException extends RuntimeException {

    private static final String MESSAGE = "Конечный клиент с Id %s не найден";

    public EndUserNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}

