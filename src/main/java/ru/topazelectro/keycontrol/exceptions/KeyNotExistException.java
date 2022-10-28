package ru.topazelectro.keycontrol.exceptions;

public class KeyNotExistException extends RuntimeException {

    private static final String MESSAGE = "Ключ с Id %s не найден";

    public KeyNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}