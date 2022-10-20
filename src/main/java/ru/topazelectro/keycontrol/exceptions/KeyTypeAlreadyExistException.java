package ru.topazelectro.keycontrol.exceptions;

public class KeyTypeAlreadyExistException extends RuntimeException {

    private static final String MESSAGE = "Такой тип ключа уже существует";

    public KeyTypeAlreadyExistException() {
        super(MESSAGE);
    }
}
