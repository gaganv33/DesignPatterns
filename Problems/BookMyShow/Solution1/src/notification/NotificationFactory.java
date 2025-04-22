package notification;

public class NotificationFactory {
    public static Notification getNotificationInstance(String notificationType) {
        return switch (notificationType) {
            case "EMAIL" -> EmailNotification.getInstance();
            case "MESSAGE" -> MessageNotification.getInstance();
            default -> null;
        };
    }
}
