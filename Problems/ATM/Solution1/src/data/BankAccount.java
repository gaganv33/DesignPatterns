package data;

import utility.AmountComputation;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private final String accountNo;
    private int balance;
    private final Map<NoteType, Integer> notes;

    public BankAccount(String accountNo) {
        this.accountNo = accountNo;
        this.balance = 0;
        this.notes = new HashMap<>();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public Map<NoteType, Integer> getNotes() {
        return notes;
    }

    public void depositAmount(Map<NoteType, Integer> giveNotes) {
        this.balance += AmountComputation.getAmount(giveNotes);
        this.notes.putAll(giveNotes);
    }

    public void withdrawAmount(Map<NoteType, Integer> withdrawNotes) {
        this.balance -= AmountComputation.getAmount(withdrawNotes);
        removeRequiredNotes(withdrawNotes);
    }

    public boolean checkIfEnoughBalance(int requiredAmount) {
        return this.balance >= requiredAmount;
    }

    public int getNumberOfNotesGiveNoteType(NoteType noteType) {
        return notes.getOrDefault(noteType, 0);
    }

    private void removeRequiredNotes(Map<NoteType, Integer> withdrawNotes) {
        for(var entry : withdrawNotes.entrySet()) {
            NoteType noteType = entry.getKey();
            int number = entry.getValue();
            if(notes.get(noteType) == number) notes.remove(noteType);
            else notes.put(noteType, notes.get(noteType) - number);
        }
    }
}
