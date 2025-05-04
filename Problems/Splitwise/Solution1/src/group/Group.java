package group;

import data.split.SplitType;
import expense.Expense;
import expense.ExpenseProxy;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String groupId;
    private final List<User> members;
    private final String description;
    private final List<Expense> expenses;
    private final ExpenseProxy expenseProxy;

    public Group(String groupId, List<User> members, String description) {
        this.groupId = groupId;
        this.members = members;
        this.description = description;
        this.expenses = new ArrayList<>();
        this.expenseProxy = new ExpenseProxy();
    }

    public String getGroupId() {
        return groupId;
    }

    public List<User> getMembers() {
        return members;
    }

    public String getDescription() {
        return description;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public Expense createExpense(String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId) {
        Expense expense = expenseProxy.createExpense(expenseId, description, amount, paidByUserId, memberUserId);
        if(expense == null) {
            System.out.println("Error while creating expense.");
            return null;
        }
        addExpense(expense);
        return expense;
    }

    public Expense createExpense(String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId, SplitType splitType, List<Double> values) {
        Expense expense = expenseProxy.createExpense(expenseId, description, amount, paidByUserId, memberUserId, splitType, values);
        if(expense == null) {
            System.out.println("Error while creating expense.");
            return null;
        }
        addExpense(expense);
        return expense;
    }

    private void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
