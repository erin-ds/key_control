package ru.topazelectro.keycontrol.exceptions;

public class SoftwareNotExistException extends RuntimeException {

    private static final String MESSAGE = "Программное обеспечение с Id %s не найден";

    public SoftwareNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}