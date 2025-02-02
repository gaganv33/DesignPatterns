public class MailNotifier extends NotificationDecorator {
    public MailNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage() {
        notifier.sendMessage();
        sendMailMessage();
    }

    public void sendMailMessage() {
        System.out.println("send a Mail notification");
    }
}
