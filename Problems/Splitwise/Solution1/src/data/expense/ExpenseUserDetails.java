package data.expense;

import user.User;

import java.util.List;

public class ExpenseUserDetails {
    private final User paidBy;
    private final List<User> members;

    public ExpenseUserDetails(User paidBy, List<User> members) {
        this.paidBy = paidBy;
        this.members = members;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<User> getMembers() {
        return members;
    }
}
