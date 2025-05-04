package notification;

import data.notification.Notification;
import notification.channel.NotificationChannel;

public class NotificationService {
    private final NotificationChannel notificationChannel;

    public NotificationService(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public void notifyUser(String recipient, String message) {
        notificationChannel.send(new Notification(recipient, message));
    }
}
