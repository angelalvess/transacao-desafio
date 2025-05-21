package com.angel.alves.transacao_desafio.authorization;

public class UnauthorizedTransactionException extends RuntimeException {
    public UnauthorizedTransactionException() {
        super("Unauthorized transaction");
    }
}
