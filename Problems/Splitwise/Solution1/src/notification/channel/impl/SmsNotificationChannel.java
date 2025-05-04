package notification.channel.impl;

import data.notification.Notification;
import notification.channel.NotificationChannel;

public class SmsNotificationChannel implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        System.out.println("Sending SMS(" + notification.getRecipient() + "): message: " + notification.getMessage());
    }
}
