package splitStrategy.impl;

import data.split.SplitDetails;
import splitStrategy.UnequalSplitStrategy;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements UnequalSplitStrategy {
    @Override
    public List<SplitDetails> getSplit(List<User> users, List<Double> values, double amount) {
        if(!validateSplit(values)) return null;
        List<SplitDetails> splitDetails = new ArrayList<>();
        int n = users.size();
        for(int i = 0; i < n; i++) {
            User user = users.get(i);
            double userAmount = (values.get(i) * amount) / 100.0;
            splitDetails.add(new SplitDetails(user, userAmount));
        }
        return splitDetails;
    }

    private boolean validateSplit(List<Double> values) {
        double totalPercentage = 0.0;
        for(var value : values) {
            totalPercentage += value;
        }
        return (totalPercentage == 100.0);
    }
}
