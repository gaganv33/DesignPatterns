package data.notification;

import notification.NotificationService;
import notification.channel.NotificationChannel;

public class NotificationDetail {
    private final NotificationService notificationService;
    private final String recipient;

    public NotificationDetail(NotificationService notificationService, String recipient) {
        this.notificationService = notificationService;
        this.recipient = recipient;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public String getRecipient() {
        return recipient;
    }
}
