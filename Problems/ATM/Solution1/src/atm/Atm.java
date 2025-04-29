package atm;

import data.Card;
import data.NoteType;
import state.*;
import state.impl.IdleStateImpl;

import java.util.Map;

public class Atm {
    private static volatile Atm instance;
    private Card card;
    private State state;

    private Atm() {
        this.state = new IdleStateImpl(this);
    }

    public static Atm getInstance() {
        if(instance == null) {
            instance = new Atm();
        }
        return instance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCard(Card card) {
        if(state instanceof IdleState) {
            ((IdleState) state).insertCard(this, card);
        } else {
            System.out.println("The state has to be in idle state.");
        }
    }

    public void enterPin(String pin) {
        if(state instanceof HasCard) {
            if(((HasCard) state).enterPin(this, pin)) {
                System.out.println("Correct pin.");
            } else {
                System.out.println("Incorrect pin.");

            }
        } else {
            System.out.println("The state has to be in hasCard state.");
        }
    }

    public void cancelFromHasCardState() {
        if(state instanceof HasCard) {
            ((HasCard) state).cancel(this);
        } else {
            System.out.println("The state has to be in hasCard state.");
        }
    }

    public void logout() {
        if(state instanceof ActiveState) {
            ((ActiveState) state).logout(this);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void selectGetBalanceInquiry() {
        if(state instanceof ActiveState) {
            ((ActiveState) state).changeToBalanceInquiryState(this);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void selectCashDeposit() {
        if(state instanceof ActiveState) {
            ((ActiveState) state).changeToCashDepositState(this);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void selectCashWithdraw() {
        if(state instanceof ActiveState) {
            ((ActiveState) state).changeToCashWithdrawalState(this);
        } else {
            System.out.println("The state has to be in active state.");
        }
    }

    public void getBalance() {
        if(state instanceof BalanceInquiryState) {
            int balance = ((BalanceInquiryState) state).getBalance(this);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("The state has to be in balanceInquiry state.");
        }
    }

    public void exitFromBalanceInquiry() {
        if(state instanceof BalanceInquiryState) {
            ((BalanceInquiryState) state).exit(this);
        } else {
            System.out.println("The state has to be in balanceInquiry state.");
        }
    }

    public void depositCash(Map<NoteType, Integer> notes) {
        if(state instanceof CashDepositState) {
            ((CashDepositState) state).cashDeposit(this, notes);
        } else {
            System.out.println("The state has to be in cashDeposit state.");
        }
    }

    public void exitFromCashDeposit() {
        if(state instanceof CashDepositState) {
            ((CashDepositState) state).exit(this);
        } else {
            System.out.println("The state has to be in cashDeposit state.");
        }
    }

    public void withdrawCash(int amount) {
        if(state instanceof CashWithdrawalState) {
            Map<NoteType, Integer> notes = ((CashWithdrawalState) state).cashWithdraw(this, amount);
            if(notes == null) {
                System.out.println("Error will withdrawing cash.");
                return;
            }
            printNotes(notes);
        } else {
            System.out.println("The state has to be in cashWithdraw state.");
        }
    }

    public void exitFromCashWithdraw() {
        if(state instanceof CashWithdrawalState) {
            ((CashWithdrawalState) state).exit(this);
        } else {
            System.out.println("The state has to be in cashWithdraw state.");
        }
    }

    public void printNotes(Map<NoteType, Integer> notes) {
        System.out.println("Withdraw notes");
        for(var entry : notes.entrySet()) {
            System.out.println(entry.getKey().getValue() + " " + entry.getValue());
        }
    }
}
