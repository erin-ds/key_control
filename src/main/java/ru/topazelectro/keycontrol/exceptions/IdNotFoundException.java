package ru.topazelectro.keycontrol.exceptions;

public class IdNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Элемент с Id: %s не найден!";

    public IdNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
