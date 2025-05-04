package splitStrategy;

import data.split.SplitDetails;
import data.split.SplitType;
import splitStrategy.impl.EqualSplitStrategyImpl;
import splitStrategy.impl.FixedAmountSplitStrategy;
import splitStrategy.impl.PercentageSplitStrategy;
import user.User;

import java.util.List;

public class SplitStrategyFactory {
    public static List<SplitDetails> getSplitUsingSplitStrategyType(List<User> users, double amount) {
        return new EqualSplitStrategyImpl().getSplit(users, amount);
    }

    public static List<SplitDetails> getSplitUsingSplitStrategyType(SplitType splitType, List<User> users, List<Double> values, double amount) {
        if(splitType.equals(SplitType.PERCENTAGE)) {
            return new PercentageSplitStrategy().getSplit(users, values, amount);
        } else if(splitType.equals(SplitType.FIXED_AMOUNT)) {
            return new FixedAmountSplitStrategy().getSplit(users, values, amount);
        } else {
            return null;
        }
    }
}
