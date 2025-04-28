package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CoinType {
    ONE(1), TWO(2), FIVE(5), TEN(10);
    private final int value;

    CoinType(int value) {
        this.value =value;
    }

    public int getValue() {
        return this.value;
    }

    public static List<CoinType> getCoinTypeList() {
        return new ArrayList<>(Arrays.asList(TEN, FIVE, TWO, ONE));
    }
}
