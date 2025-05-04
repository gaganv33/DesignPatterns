package splitStrategy.impl;

import data.split.SplitDetails;
import splitStrategy.EqualSplitStrategy;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategyImpl implements EqualSplitStrategy {
    @Override
    public List<SplitDetails> getSplit(List<User> users, double amount) {
        List<SplitDetails> splitDetails = new ArrayList<>();
        int n = users.size();
        double target = (amount / n);
        for(var user : users) {
            splitDetails.add(new SplitDetails(user, target));
        }
        return splitDetails;
    }
}
