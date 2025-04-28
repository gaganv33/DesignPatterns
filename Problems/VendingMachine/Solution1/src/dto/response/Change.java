package dto.response;

import data.CoinType;
import data.NoteType;
import utility.AmountComputation;

import java.util.Map;

public class Change {
    private final Map<CoinType, Integer> coins;
    private final Map<NoteType, Integer> notes;

    public Change(Map<CoinType, Integer> coins, Map<NoteType, Integer> notes) {
        this.coins = coins;
        this.notes = notes;
    }

    public Map<CoinType, Integer> getCoins() {
        return coins;
    }

    public Map<NoteType, Integer> getNotes() {
        return notes;
    }

    public int getTotalAmount() {
        return AmountComputation.getAmountCoins(coins) + AmountComputation.getAmountNotes(notes);
    }
}
