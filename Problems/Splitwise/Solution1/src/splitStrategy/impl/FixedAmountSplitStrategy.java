package splitStrategy.impl;

import data.split.SplitDetails;
import splitStrategy.UnequalSplitStrategy;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class FixedAmountSplitStrategy implements UnequalSplitStrategy {
    @Override
    public List<SplitDetails> getSplit(List<User> users, List<Double> values, double amount) {
        if(!validateSplit(values, amount)) return null;
        List<SplitDetails> splitDetails = new ArrayList<>();
        int n = users.size();
        for(int i = 0; i < n; i++) {
            User user = users.get(i);
            double userAmount = values.get(i);
            splitDetails.add(new SplitDetails(user, userAmount));
        }
        return splitDetails;
    }

    public boolean validateSplit(List<Double> values, double amount) {
        double totalAmount = 0;
        for(var value : values) {
            totalAmount += value;
        }
        return (totalAmount == amount);
    }
}
