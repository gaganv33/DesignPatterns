package notification;

import user.User;

public class MessageNotification implements Notification {
    private static volatile MessageNotification instance;
    private MessageNotification() {}

    public static MessageNotification getInstance() {
        if(instance == null) {
            synchronized (MessageNotification.class) {
                if(instance == null) {
                    instance = new MessageNotification();
                }
            }
        }
        return instance;
    }

    @Override
    public void sendMessage(User user) {
        System.out.println("PhoneNo: " + user.getPhoneNo() + ", seats are now available.");
    }
}
