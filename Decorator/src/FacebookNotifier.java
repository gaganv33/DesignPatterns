public class FacebookNotifier extends NotificationDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage() {
        notifier.sendMessage();
        sendFacebookMessage();
    }

    public void sendFacebookMessage() {
        System.out.println("Send a Facebook notification");
    }
}
