package splitStrategy;

import data.split.SplitDetails;
import user.User;

import java.util.List;

public interface UnequalSplitStrategy extends SplitStrategy {
    List<SplitDetails> getSplit(List<User> users, List<Double> values, double amount);
}
