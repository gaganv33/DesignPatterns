package group;

import data.split.SplitType;
import expense.Expense;
import user.User;
import user.UserManager;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class GroupManager {
    private static volatile GroupManager instance;
    private final ConcurrentHashMap<String, Group> groups;
    private final UserManager userManager;

    private GroupManager() {
        this.groups = new ConcurrentHashMap<>();
        this.userManager = UserManager.getInstance();
    }

    public static GroupManager getInstance() {
        if(instance == null) {
            synchronized (GroupManager.class) {
                if(instance == null) {
                    instance = new GroupManager();
                }
            }
        }
        return instance;
    }

    public void addGroup(String groupId, List<String> memberUserId, String description) {
        groups.put(groupId, new Group(groupId, userManager.getUsersUsingUserId(memberUserId), description));
    }

    public boolean addMemberInGroupUsingGroupId(String groupId, String userId) {
        User user = userManager.getUserUsingUserId(userId);
        if(user == null) {
            System.out.println("Invalid user id.");
            return false;
        }
        Group group = getGroupUsingGroupId(groupId);
        if(group == null) {
            System.out.println("Invalid group id.");
            return false;
        }
        group.addMember(user);
        return true;
    }

    public Expense createExpense(String groupId, String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId) {
        Group group = getGroupUsingGroupId(groupId);
        if(group == null) {
            System.out.println("Invalid group id.");
            return null;
        }
        return group.createExpense(expenseId, description, amount, paidByUserId, memberUserId);
    }

    public Expense createExpense(String groupId, String expenseId, String description, double amount, String paidByUserId, List<String> memberUserId, SplitType splitType, List<Double> values) {
        Group group = getGroupUsingGroupId(groupId);
        if(group == null) {
            System.out.println("Invalid group id.");
            return null;
        }
        return group.createExpense(expenseId, description, amount, paidByUserId, memberUserId, splitType, values);
    }

    public Group getGroupUsingGroupId(String groupId) {
        return groups.getOrDefault(groupId, null);
    }
}
