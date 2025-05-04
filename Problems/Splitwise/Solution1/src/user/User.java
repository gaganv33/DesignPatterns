package user;

import balanceSheet.BalanceSheet;
import data.user.Profile;

public class User {
    private final String userId;
    private String name;
    private String email;
    private String phoneNo;
    private final BalanceSheet balanceSheet;

    public User(String userId, String name, String email, String phoneNo) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.balanceSheet = new BalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void updateProfile(Profile profile) {
        setName(profile.getName());
        setEmail(profile.getEmail());
        setPhoneNo(profile.getPhoneNo());
    }

    public void addUserToPayment(String userId, double amount) {
        balanceSheet.addUserToPayment(userId, amount);
    }

    public void addAmountToReceive(String userId, double amount) {
        balanceSheet.addAmountToReceive(userId, amount);
    }
}
