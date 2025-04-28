package utility;

import data.CoinType;
import data.NoteType;

import java.util.Map;

public class AmountComputation {
    public static int getAmountCoins(Map<CoinType, Integer> coins) {
        int totalAmount = 0;
        for(var x : coins.entrySet()) {
            totalAmount += (x.getKey().getValue() * x.getValue());
        }
        return totalAmount;
    }

    public static int getAmountNotes(Map<NoteType, Integer> notes) {
        int totalAmount = 0;
        for(var x : notes.entrySet()) {
            totalAmount += (x.getKey().getValue() * x.getValue());
        }
        return totalAmount;
    }
}
