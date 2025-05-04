package notification.channel.impl;

import data.notification.Notification;
import notification.channel.NotificationChannel;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(Notification notification) {
        System.out.println("Sending Email(" + notification.getRecipient() + "): message: " + notification.getMessage());
    }
}
