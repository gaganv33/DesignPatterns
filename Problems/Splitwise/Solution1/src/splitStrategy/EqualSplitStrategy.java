package splitStrategy;

import data.split.SplitDetails;
import user.User;

import java.util.List;

public interface EqualSplitStrategy extends SplitStrategy {
    List<SplitDetails> getSplit(List<User> users, double amount);
}
