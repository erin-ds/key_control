package ru.topazelectro.keycontrol.exceptions;

public class PartnerAlreadyExistException extends RuntimeException {

    private static final String MESSAGE = "Контрагент с таким именем или названием уже существует";

    public PartnerAlreadyExistException() {
        super(MESSAGE);
    }
}
