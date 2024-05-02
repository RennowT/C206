package com.corretora.model.inputValidator;

import java.util.Scanner;

public abstract class InputValidator<T> {
    protected final String request;

    protected InputValidator(String request) {
        this.request = request;
    }

    abstract T validateInput(Scanner sc);
}
