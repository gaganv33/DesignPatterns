public class Main {
    public static void main(String[] args) {
        Notifier notifier = new MailNotifier(new FacebookNotifier(new SmsNotifier(new ApplicationNotifier())));
        System.out.println("---notification 1---");
        notifier.sendMessage();

        System.out.println("---notification 2---");
        Notifier notifier1 = new MailNotifier(new ApplicationNotifier());
        notifier1.sendMessage();
    }
}