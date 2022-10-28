package ru.topazelectro.keycontrol.exceptions;

public class KeyGroupNotExistException extends RuntimeException {

    private static final String MESSAGE = "Группа ключей с Id %s не найден";

    public KeyGroupNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}