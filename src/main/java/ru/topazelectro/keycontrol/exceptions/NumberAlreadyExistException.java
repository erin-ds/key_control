package ru.topazelectro.keycontrol.exceptions;

public class NumberAlreadyExistException extends RuntimeException{

    private static final String MESSAGE = "Группа с таким номером уже существует";

    public NumberAlreadyExistException() {
        super(MESSAGE);
    }
}
