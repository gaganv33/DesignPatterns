package notification;

import user.User;

public class EmailNotification implements Notification {
    private static volatile EmailNotification instance;
    private EmailNotification() {}

    public static EmailNotification getInstance() {
        if(instance == null) {
            synchronized (EmailNotification.class) {
                if(instance == null) {
                    instance = new EmailNotification();
                }
            }
        }
        return instance;
    }

    @Override
    public void sendMessage(User user) {
        System.out.println("Email: " + user.getEmail() + ", seats are now available.");
    }
}
