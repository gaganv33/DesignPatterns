public class SmsNotifier extends NotificationDecorator {
    public SmsNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage() {
        notifier.sendMessage();
        sendSmsMessage();
    }

    public void sendSmsMessage() {
        System.out.println("Send an SMS notification");
    }
}
