package ru.topazelectro.keycontrol.exceptions;

public class KeyNumberNotExistException extends RuntimeException {

    private static final String MESSAGE = "Ключ с номером %s не найден";

    public KeyNumberNotExistException(String hex) {
        super(String.format(MESSAGE, hex));
    }
}