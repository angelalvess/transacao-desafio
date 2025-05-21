package com.angel.alves.transacao_desafio.authorization;

import com.angel.alves.transacao_desafio.transaction.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizationService {



    // responsavel por fazer request para mock externo de autorizacao, Rest client
    private final RestClient restClient;

    public AuthorizationService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://util.devi.tools/api/v2/authorize").build();
    }


    public void authorized(Transaction transaction){
        var result = restClient.get().retrieve().toEntity(Authorization.class);

        if (result.getStatusCode().isError() || result.getBody().status().equals("fail")){
            throw new UnauthorizedTransactionException();
        }
    }

}
