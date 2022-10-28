package ru.topazelectro.keycontrol.exceptions;

public class PartnerNotExistException extends RuntimeException {

    private static final String MESSAGE = "Контрагент с Id %s не найден";

    public PartnerNotExistException(Long id) {
        super(String.format(MESSAGE, id));
    }
}

