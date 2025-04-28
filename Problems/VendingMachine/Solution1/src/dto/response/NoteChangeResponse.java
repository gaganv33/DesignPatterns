package dto.response;

import data.NoteType;

import java.util.Map;

public class NoteChangeResponse {
    private final int amount;
    private final Map<NoteType, Integer> notes;

    public NoteChangeResponse(int amount, Map<NoteType, Integer> notes) {
        this.amount = amount;
        this.notes = notes;
    }

    public int getAmount() {
        return amount;
    }

    public Map<NoteType, Integer> getNotes() {
        return notes;
    }
}
