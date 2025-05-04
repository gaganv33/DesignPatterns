package expense;

import data.expense.ExpenseUserDetails;
import data.split.SplitDetails;
import data.split.SplitType;
import splitStrategy.SplitStrategyFactory;
import user.User;
import user.UserManager;

import java.util.ArrayList;
import java.util.List;

public class ExpenseProxy {
    private final UserManager userManager;

    public ExpenseProxy() {
        this.userManager = UserManager.getInstance();
    }

    public Expense createExpense(String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId) {
        if(memberUserId.isEmpty()) {
            System.out.println("Members list cannot be empty.");
            return null;
        }
        ExpenseUserDetails expenseUserDetails = getExpenseUserDetails(paidByUserId, memberUserId);
        if(expenseUserDetails.getPaidBy() == null) {
            System.out.println("Paid by user id is invalid.");
            return null;
        }
        User paidBy = expenseUserDetails.getPaidBy();
        List<User> members = expenseUserDetails.getMembers();
        List<SplitDetails> splitDetails = SplitStrategyFactory.getSplitUsingSplitStrategyType(members, amount);
        if(splitDetails == null) {
            System.out.println("Error while creating splits");
            return null;
        }
        updateBalanceSheet(splitDetails, paidBy);
        return new Expense(expenseId, description, amount, paidBy, SplitType.EQUAL, members, splitDetails);
    }

    public Expense createExpense(String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId, SplitType splitType, List<Double> values) {
        if(memberUserId.isEmpty()) {
            System.out.println("Members list cannot be empty.");
            return null;
        }
        if(memberUserId.size() != values.size()) {
            System.out.println("The size of the members list has to match with the values list");
            return null;
        }
        ExpenseUserDetails expenseUserDetails = getExpenseUserDetails(paidByUserId, memberUserId);
        if(expenseUserDetails.getPaidBy() == null) {
            System.out.println("Paid by user id is invalid.");
            return null;
        }
        User paidBy = expenseUserDetails.getPaidBy();
        List<User> members = expenseUserDetails.getMembers();
        List<SplitDetails> splitDetails = SplitStrategyFactory.getSplitUsingSplitStrategyType(splitType, members, values, amount);
        if(splitDetails == null) {
            System.out.println("Paid by user id is invalid.");
            return null;
        }
        updateBalanceSheet(splitDetails, paidBy);
        return new Expense(expenseId, description, amount, paidBy, splitType, members, splitDetails);
    }

    private void updateBalanceSheet(List<SplitDetails> splitDetails, User paidBy) {
        for(var splitDetail : splitDetails) {
            User user = splitDetail.getUser();
            double amount = splitDetail.getAmount();
            if(!user.getUserId().equals(paidBy.getUserId())) {
                user.addUserToPayment(paidBy.getUserId(), amount);
                paidBy.addAmountToReceive(user.getUserId(), amount);
            }
        }
    }

    private ExpenseUserDetails getExpenseUserDetails(String paidByUserId, List<String> memberUserId) {
        return new ExpenseUserDetails(userManager.getUserUsingUserId(paidByUserId), userManager.getUsersUsingUserId(memberUserId));
    }
}
