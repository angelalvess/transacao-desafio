package com.angel.alves.transacao_desafio.notification;

public class NotificationException extends RuntimeException {
    public NotificationException() {
        super("Error to send notification");
    }
}
