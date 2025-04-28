package amount;

import data.NoteType;
import dto.response.NoteChangeResponse;
import utility.AmountComputation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteManager {
    private static volatile NoteManager instance;
    private Map<NoteType, Integer> notes;

    private NoteManager() {
        this.notes = new HashMap<>();
    }

    public static NoteManager getInstance() {
        if(instance == null) {
            instance = new NoteManager();
        }
        return instance;
    }

    public Map<NoteType, Integer> getNotes() {
        return notes;
    }

    private void setNotes(Map<NoteType, Integer> notes) {
        this.notes = notes;
    }

    public void addNotes(Map<NoteType, Integer> newNotes) {
        for(var entrySet : newNotes.entrySet()) {
            NoteType key = entrySet.getKey();
            int value = entrySet.getValue();
            notes.put(key, notes.getOrDefault(key, 0) + value);
        }
    }

    public void clearNotes() {
        setNotes(new HashMap<>());
    }

    public int getAmount() {
        return AmountComputation.getAmountNotes(notes);
    }

    public NoteChangeResponse getNoteChange(int balanceAmount) {
        int amount = 0;
        Map<NoteType, Integer> noteChange = new HashMap<>();
        List<NoteType> noteTypeList = NoteType.getNoteTypeList();

        int i = 0;
        int n = noteTypeList.size();
        while(i < n && balanceAmount > 0) {
            NoteType noteType = noteTypeList.get(i);
            int requiredNotes = (balanceAmount / noteType.getValue());
            if(requiredNotes > 0 && checkIfEnoughNotes(noteType, requiredNotes)) {
                removeNotes(noteType, requiredNotes);
                noteChange.put(noteType, requiredNotes);
                balanceAmount -= (noteType.getValue() * requiredNotes);
                amount += (noteType.getValue() * requiredNotes);
            }
            i++;
        }
        return new NoteChangeResponse(amount, noteChange);
    }

    private void removeNotes(NoteType noteType, int quantity) {
        if(notes.get(noteType) == quantity) notes.remove(noteType);
        else notes.put(noteType, notes.get(noteType) - quantity);
    }

    private boolean checkIfEnoughNotes(NoteType noteType, int quantity) {
        return notes.getOrDefault(noteType, 0) >= quantity;
    }
}
