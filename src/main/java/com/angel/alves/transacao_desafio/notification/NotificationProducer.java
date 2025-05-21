package com.angel.alves.transacao_desafio.notification;


import com.angel.alves.transacao_desafio.transaction.Transaction;
import org.springframework.kafka.core.KafkaTemplate;

public class NotificationProducer {

    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(Transaction transaction) {
        kafkaTemplate.send("transaction-notification", transaction);
    }
}
