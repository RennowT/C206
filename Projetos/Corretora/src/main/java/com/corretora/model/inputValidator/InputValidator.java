package com.corretora.model.inputValidator;

import java.util.Scanner;

public abstract class InputValidator<T> {

    public abstract T validateInput(Scanner sc);
}
