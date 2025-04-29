package data;

import java.time.LocalDate;
import java.util.Map;

public class Card {
    private final String cardNumber;
    private final String cvvNumber;
    private final LocalDate expiryDate;
    private final String pin;
    private final BankAccount bankAccount;
    private final User user;

    public Card(String cardNumber, String cvvNumber, LocalDate expiryDate, String pin, BankAccount bankAccount, User user) {
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.bankAccount = bankAccount;
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getPin() {
        return pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public User getUser() {
        return user;
    }

    public int getBalance() {
        return bankAccount.getBalance();
    }

    public void depositAmount(Map<NoteType, Integer> notes) {
        bankAccount.depositAmount(notes);
    }

    public void withdrawAmount(Map<NoteType, Integer> notes) {
        bankAccount.withdrawAmount(notes);
    }

    public boolean checkIfEnoughBalance(int requiredAmount) {
        return bankAccount.checkIfEnoughBalance(requiredAmount);
    }

    public boolean checkIfPinIsMatching(String clientPin) {
        return pin.equals(clientPin);
    }

    public int getNumberOfNotesGiveNoteType(NoteType noteType) {
        return bankAccount.getNumberOfNotesGiveNoteType(noteType);
    }
}
