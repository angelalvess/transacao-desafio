package com.angel.alves.transacao_desafio.notification;

import com.angel.alves.transacao_desafio.authorization.UnauthorizedTransactionException;
import com.angel.alves.transacao_desafio.transaction.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestClient;

public class NotificationConsumer {

    private final RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://util.devi.tools/api/v1/notify").build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "group-01")
    public void  receivedNotification(Transaction transaction){
        var result = restClient.get().retrieve().toEntity(Notification.class);

            if (result.getStatusCode().isError() || result.getBody().status().equals("fail")){
                throw new NotificationException();
            }
        }
    }

