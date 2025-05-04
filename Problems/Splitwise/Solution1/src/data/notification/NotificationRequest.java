package data.notification;

import user.User;

public class NotificationRequest {
    private final NotificationChannelType notificationChannelType;
    private final User user;
    private final String message;

    public NotificationRequest(NotificationChannelType notificationChannelType, User user, String message) {
        this.notificationChannelType = notificationChannelType;
        this.user = user;
        this.message = message;
    }

    public NotificationChannelType getNotificationChannelType() {
        return notificationChannelType;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
