package com.angel.alves.transacao_desafio.wallet;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record Wallet(
        @Id
        Long id,
        String fullName,
        int cpf,
        String email,
        String senha,
        int type,
        BigDecimal balance
) {
}
