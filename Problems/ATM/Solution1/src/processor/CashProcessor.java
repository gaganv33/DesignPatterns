package processor;

import atm.Atm;
import data.NoteType;

import java.util.HashMap;
import java.util.Map;

public abstract class CashProcessor {
    protected final CashProcessor next;
    protected final NoteType noteType;

    CashProcessor(CashProcessor cashProcessor, NoteType noteType) {
        this.next = cashProcessor;
        this.noteType = noteType;
    }

    public Map<NoteType, Integer> withdrawNotes(Atm atm, int amount) {
        Map<NoteType, Integer> notes = new HashMap<>();
        int requiredNotes = (amount / noteType.getValue());

        if(requiredNotes > 0 && atm.getCard().getNumberOfNotesGiveNoteType(noteType) >= requiredNotes) {
            notes.put(noteType, requiredNotes);
            amount -= (noteType.getValue() * requiredNotes);
        }

        if(amount > 0) {
            if(next == null) return null;
            Map<NoteType, Integer> nextNotes = next.withdrawNotes(atm, amount);
            if(nextNotes == null) return null;
            notes.putAll(nextNotes);
        }
        return notes;
    }
}
