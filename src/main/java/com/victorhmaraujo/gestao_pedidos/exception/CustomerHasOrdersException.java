package com.victorhmaraujo.gestao_pedidos.exception;

public class CustomerHasOrdersException extends RuntimeException {
    public CustomerHasOrdersException(String message) {
        super(message);
    }
}
