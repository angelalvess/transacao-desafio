package com.angel.alves.transacao_desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class TransacaoDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoDesafioApplication.class, args);
	}

}
