package notification;

import data.notification.NotificationChannelType;
import data.notification.NotificationDetail;
import data.notification.NotificationRequest;
import notification.channel.impl.EmailNotificationChannel;
import notification.channel.impl.SmsNotificationChannel;
import user.User;

public class NotificationDetailFactory {
    public static NotificationDetail getNotificationDetail(NotificationRequest notificationRequest) {
        NotificationChannelType notificationChannelType = notificationRequest.getNotificationChannelType();
        User user = notificationRequest.getUser();
        return switch (notificationChannelType) {
            case SMS -> new NotificationDetail(new NotificationService(new SmsNotificationChannel()), user.getPhoneNo());
            case EMAIL -> new NotificationDetail(new NotificationService(new EmailNotificationChannel()), user.getEmail());
        };
    }
}
