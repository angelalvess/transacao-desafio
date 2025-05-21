package com.angel.alves.transacao_desafio.authorization;

public record Authorization(String status, Data data) {
}

record Data(boolean authorization ){}