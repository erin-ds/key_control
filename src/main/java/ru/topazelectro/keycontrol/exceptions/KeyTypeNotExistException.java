package ru.topazelectro.keycontrol.exceptions;

public class KeyTypeNotExistException extends RuntimeException {

    private static final String MESSAGE = "Тип ключа с Id %s не найден";

    public KeyTypeNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}