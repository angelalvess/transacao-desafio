package com.angel.alves.transacao_desafio.wallet;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("WALLETS")
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

    public Wallet debit(BigDecimal value) {
        return new Wallet(id, fullName, cpf, email, senha, type, balance.subtract(value));
    }

    public Wallet credit(BigDecimal value) {
        return new Wallet(id, fullName, cpf, email, senha, type, balance.add(value));
    }

}
