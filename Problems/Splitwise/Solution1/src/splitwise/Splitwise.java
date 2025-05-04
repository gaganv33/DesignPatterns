package splitwise;

import data.split.SplitDetails;
import data.split.SplitType;
import data.user.Profile;
import expense.Expense;
import group.GroupManager;
import user.User;
import user.UserManager;

import java.util.List;

public class Splitwise {
    private final UserManager userManager;
    private final GroupManager groupManager;

    public Splitwise() {
        userManager = UserManager.getInstance();
        groupManager = GroupManager.getInstance();
    }

    public void addUser(User user) {
        userManager.addUser(user);
    }

    public void updateProfile(String userId, Profile profile) {
        if(userManager.updateProfileUsingUserId(userId, profile)) {
            System.out.println("Successfully updated profile.");
        } else {
            System.out.println("Error while updating profile.");
        }
    }

    public void getUser(String userId) {
        User user = userManager.getUserUsingUserId(userId);
        if(user == null) {
            System.out.println("Invalid user profile.");
        } else {
            System.out.println(user.getUserId() + " " + user.getName() + " " + user.getEmail() + " " + user.getPhoneNo());
        }
    }

    public void addGroup(String groupId, List<String> memberUserId, String description) {
        groupManager.addGroup(groupId, memberUserId, description);
    }

    public void addMemberToGroup(String groupId, String userId) {
        if(groupManager.addMemberInGroupUsingGroupId(groupId, userId)) {
            System.out.println("Member added successfully.");
        } else {
            System.out.println("Error while adding member to group successfully.");
        }
    }

    public void createExpense(String groupId, String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId) {
        Expense expense = groupManager.createExpense(groupId, expenseId, description, amount, paidByUserId, memberUserId);
        if(expense == null) {
            System.out.println("Error while creating expense.");
        } else {
            printExpense(expense);
        }
    }

    public void createExpense(String groupId, String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId, SplitType splitType, List<Double> values) {
        Expense expense = groupManager.createExpense(groupId, expenseId, description, amount, paidByUserId, memberUserId, splitType, values);
        if(expense == null) {
            System.out.println("Error while creating expense.");
        } else {
            printExpense(expense);
        }
    }

    public void printBalanceSheet(String userId) {
        userManager.printBalanceSheet(userId);
    }

    private void printExpense(Expense expense) {
        System.out.println("Expense Id: " + expense.getExpenseId());
        System.out.println("Description: " + expense.getDescription());
        System.out.println("Amount: " + expense.getAmount());
        System.out.println("Paid by: " + expense.getPaidBy().getUserId() + " " + expense.getPaidBy().getName());
        System.out.println("SplitType: " + expense.getSplitType());
        List<SplitDetails> splitDetails = expense.getSplitDetails();
        System.out.println("Split details");
        for(var splitDetail : splitDetails) {
            System.out.println(splitDetail.getUser().getUserId() + ", " + splitDetail.getUser().getName() + " : " + splitDetail.getAmount());
        }
    }
}
