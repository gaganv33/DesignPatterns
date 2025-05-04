package expense;

import data.notification.NotificationChannelType;
import data.notification.NotificationRequest;
import data.split.SplitDetails;
import data.split.SplitType;
import notification.NotificationManager;
import user.User;

import java.util.List;

public class Expense {
    private final String expenseId;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final SplitType splitType;
    private final List<User> members;
    private final List<SplitDetails> splitDetails;
    private final NotificationManager notificationManager;

    public Expense(String expenseId, String description, double amount, User paidBy, SplitType splitType, List<User> members, List<SplitDetails> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.members = members;
        this.splitDetails = splitDetails;
        this.notificationManager = new NotificationManager();

        notifyUsers();
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<SplitDetails> getSplitDetails() {
        return splitDetails;
    }

    public void notifyUsers() {
        String message = "You are added in a expense group. Description: " + this.description;
        for(User user : members) {
            notificationManager.notifyUser(new NotificationRequest(NotificationChannelType.SMS, user, message));
            notificationManager.notifyUser(new NotificationRequest(NotificationChannelType.EMAIL, user, message));
        }
    }
}
