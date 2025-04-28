package data;

import dto.request.ItemData;
import utility.AmountComputation;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineData {
    private final Map<ItemData, Integer> items;
    private final Map<CoinType, Integer> coins;
    private final Map<NoteType, Integer> notes;

    public VendingMachineData() {
        this.items = new HashMap<>();
        this.coins = new HashMap<>();
        this.notes = new HashMap<>();
    }

    public Map<ItemData, Integer> getItems() {
        return items;
    }

    public Map<CoinType, Integer> getCoins() {
        return coins;
    }

    public Map<NoteType, Integer> getNotes() {
        return notes;
    }

    public void addItems(ItemData itemData, int quantity) {
        items.put(itemData, items.getOrDefault(itemData, 0) + quantity);
    }

    public boolean removeItems(ItemData itemData, int quantity) {
        if(!items.containsKey(itemData) || items.get(itemData) < quantity) return false;
        if(items.get(itemData) == quantity) {
            items.remove(itemData);
        } else {
            items.put(itemData, items.get(itemData) - quantity);
        }
        return true;
    }

    public void addCoin(CoinType coinType) {
        coins.put(coinType, coins.getOrDefault(coinType, 0) + 1);
    }

    public void addNote(NoteType noteType) {
        notes.put(noteType, notes.getOrDefault(noteType, 0) + 1);
    }

    public int getTotalAmountOfItems() {
        int totalAmount = 0;
        for(var x : items.entrySet()) {
            totalAmount += (x.getKey().getItem().getPrice() * x.getValue());
        }
        return totalAmount;
    }

    public int getTotalAmount() {
        return AmountComputation.getAmountCoins(coins) + AmountComputation.getAmountNotes(notes);
    }
}
