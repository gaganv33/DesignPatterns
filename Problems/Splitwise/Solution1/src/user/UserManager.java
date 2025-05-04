package user;

import data.user.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private static volatile UserManager instance;
    private final Map<String, User> users;

    private UserManager() {
        this.users = new ConcurrentHashMap<>();
    }

    public static UserManager getInstance() {
        if(instance == null) {
            synchronized (UserManager.class) {
                if(instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public boolean updateProfileUsingUserId(String userId, Profile profile) {
        User user = getUserUsingUserId(userId);
        if(user == null) return false;
        user.updateProfile(profile);
        return true;
    }

    public void printBalanceSheet(String userId) {
        User user = getUserUsingUserId(userId);
        if(user == null) {
            System.out.println("Invalid user id.");
        } else {
            System.out.println(user.getBalanceSheet());
        }
    }

    public User getUserUsingUserId(String userId) {
        return users.getOrDefault(userId, null);
    }

    public List<User> getUsersUsingUserId(List<String> userIds) {
        List<User> users = new ArrayList<>();
        for(var userId : userIds) {
            User user = getUserUsingUserId(userId);
            if(user != null) users.add(user);
        }
        return users;
    }
}
