package notification.channel;

import data.notification.Notification;

public interface NotificationChannel {
    void send(Notification notification);
}
