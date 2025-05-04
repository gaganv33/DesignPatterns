package data.split;

import user.User;

public class SplitDetails {
    private final User user;
    private final double amount;


    public SplitDetails(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}
