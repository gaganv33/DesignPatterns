package amount;

import data.CoinType;
import data.NoteType;
import dto.response.CoinChangeResponse;
import dto.response.NoteChangeResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashProxy {
    private static volatile CashProxy instance;
    private final CoinManager coinManager;
    private final NoteManager noteManager;

    private CashProxy() {
        this.coinManager = CoinManager.getInstance();
        this.noteManager = NoteManager.getInstance();
        addCoinsForReturningChange();
        addNotesForReturningChange();
    }

    public static CashProxy getInstance() {
        if(instance == null) {
            instance = new CashProxy();
        }
        return instance;
    }

    public void addCoins(Map<CoinType, Integer> coins) {
        coinManager.addCoins(coins);
    }

    public void addNotes(Map<NoteType, Integer> notes) {
        noteManager.addNotes(notes);
    }

    public int totalAmount() {
        return totalAmountCoins() + totalAmountNotes();
    }

    public void clearCash() {
        clearCoins();
        clearNotes();
    }

    public NoteChangeResponse getNoteChange(int balanceAmount) {
        return noteManager.getNoteChange(balanceAmount);
    }

    public CoinChangeResponse getCoinChange(int balanceAmount) {
        return coinManager.getCoinChange(balanceAmount);
    }

    private int totalAmountCoins() {
        return coinManager.getAmount();
    }

    private int totalAmountNotes() {
        return noteManager.getAmount();
    }

    private void clearCoins() {
        coinManager.clearCoins();
    }

    private void clearNotes() {
        noteManager.clearNotes();
    }

    private void addCoinsForReturningChange() {
        List<CoinType> coinTypeList = CoinType.getCoinTypeList();
        Map<CoinType, Integer> coins = new HashMap<>();
        for(var x : coinTypeList) {
            coins.put(x, 100);
        }
        addCoins(coins);
    }

    private void addNotesForReturningChange() {
        List<NoteType> noteTypeList = NoteType.getNoteTypeList();
        Map<NoteType, Integer> notes = new HashMap<>();
        for(var x : noteTypeList) {
            notes.put(x, 100);
        }
        addNotes(notes);
    }
}
