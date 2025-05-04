package notification;

import data.notification.NotificationDetail;
import data.notification.NotificationRequest;

public class NotificationManager {
    public void notifyUser(NotificationRequest notificationRequest) {
        NotificationDetail notificationDetail = NotificationDetailFactory.getNotificationDetail(notificationRequest);
        NotificationService notificationService = notificationDetail.getNotificationService();
        String recipient = notificationDetail.getRecipient();
        String message = notificationRequest.getMessage();
        notificationService.notifyUser(recipient, message);
    }
}
