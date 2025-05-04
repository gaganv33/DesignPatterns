import data.split.SplitType;
import splitwise.Splitwise;
import user.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();
        addUser(splitwise);
        splitwise.addGroup("group-1", new ArrayList<>(Arrays.asList("user-1", "user-2", "user-3")), "Description-1");
        splitwise.addGroup("group-2", new ArrayList<>(Arrays.asList("user-2", "user-3", "user-4")), "Description-1");
        splitwise.createExpense("group-1", "expense-1", "outing-1", 1000.0, "user-1", new ArrayList<>(Arrays.asList("user-1", "user-2", "user-3")));
        printBalanceSheets(splitwise);
        splitwise.createExpense("group-2", "expense-2", "outing-3", 2536.0, "user-4", new ArrayList<>(Arrays.asList("user-3", "user-2", "user-4")), SplitType.PERCENTAGE, new ArrayList<>(Arrays.asList(60.0, 20.0, 20.0)));
        printBalanceSheets(splitwise);
    }

    public static void addUser(Splitwise splitwise) {
        splitwise.addUser(new User("user-1", "User 1", "user1@gmail.com", "123456789"));
        splitwise.addUser(new User("user-2", "User 2", "user2@gmail.com", "123456789"));
        splitwise.addUser(new User("user-3", "User 3", "user3@gmail.com", "123456789"));
        splitwise.addUser(new User("user-4", "User 4", "user4@gmail.com", "123456789"));
    }

    public static void printBalanceSheets(Splitwise splitwise) {
        splitwise.printBalanceSheet("user-1");
        splitwise.printBalanceSheet("user-2");
        splitwise.printBalanceSheet("user-3");
        splitwise.printBalanceSheet("user-4");
    }
}