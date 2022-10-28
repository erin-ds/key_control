package ru.topazelectro.keycontrol.exceptions;

public class SaleNotExistException extends RuntimeException {

    private static final String MESSAGE = "Продажа с Id %s не найден";

    public SaleNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}