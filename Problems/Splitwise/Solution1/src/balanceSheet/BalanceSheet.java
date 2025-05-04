package balanceSheet;

import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private final ConcurrentHashMap<String, Double> paymentPending;
    private double totalAmountToPay;
    private final ConcurrentHashMap<String, Double> paymentToReceive;
    private double totalAmountToReceive;

    public BalanceSheet() {
        this.paymentPending = new ConcurrentHashMap<>();
        this.paymentToReceive = new ConcurrentHashMap<>();
        this.totalAmountToPay = 0;
        this.totalAmountToReceive = 0;
    }

    public ConcurrentHashMap<String, Double> getPaymentPending() {
        return paymentPending;
    }

    public double getTotalAmountToPay() {
        return totalAmountToPay;
    }

    private ConcurrentHashMap<String, Double> getPaymentToReceive() {
        return paymentToReceive;
    }

    public double getTotalAmountToReceive() {
        return totalAmountToReceive;
    }

    public void addUserToPayment(String userId, double amount) {
        paymentPending.put(userId, paymentPending.getOrDefault(userId, 0.0) + amount);
        totalAmountToPay += amount;
    }

    public void addAmountToReceive(String userId, double amount) {
        paymentToReceive.put(userId, paymentToReceive.getOrDefault(userId, 0.0) + amount);
        totalAmountToReceive += amount;
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
                "paymentPending=" + paymentPending +
                ", totalAmountToPay=" + totalAmountToPay +
                ", paymentToReceive=" + paymentToReceive +
                ", totalAmountToReceive=" + totalAmountToReceive +
                '}';
    }
}
