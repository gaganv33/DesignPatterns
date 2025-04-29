import atm.Atm;
import data.BankAccount;
import data.Card;
import data.NoteType;
import data.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("1234-1234-1234", "123", LocalDate.of(2027, 1, 1),
                "1234",
                new BankAccount("123456789"),
                new User("User-1", LocalDate.of(2000, 1, 1), "123456789", "user1@gmail.com"));

        Atm atm = Atm.getInstance();
        atm.insertCard(card);

        atm.enterPin("1234");

        atm.selectGetBalanceInquiry();
        atm.getBalance();
        atm.exitFromBalanceInquiry();

        atm.selectCashDeposit();

        Map<NoteType, Integer> notes = new HashMap<>();
        notes.put(NoteType.FIVEHUNDRED, 10);
        notes.put(NoteType.TWOHUNDRED, 10);
        notes.put(NoteType.HUNDRED, 10);
        notes.put(NoteType.FIFTY, 10);
        notes.put(NoteType.TWENTY, 10);
        notes.put(NoteType.TEN, 10);

        atm.depositCash(notes);
        atm.exitFromCashDeposit();

        atm.selectGetBalanceInquiry();
        atm.getBalance();
        atm.exitFromBalanceInquiry();

        atm.selectCashWithdraw();
        atm.withdrawCash(5460);
        atm.exitFromCashWithdraw();

        atm.selectGetBalanceInquiry();
        atm.getBalance();
        atm.exitFromBalanceInquiry();

        atm.logout();
    }
}