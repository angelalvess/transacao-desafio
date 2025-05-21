package com.angel.alves.transacao_desafio.transaction;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("TRANSACTIONS")
public record Transaction(
        @Id
        Long id,
        BigDecimal value,
        Long payer,
        Long payee,
        @CreatedDate
        LocalDateTime createdAt
) {


}
