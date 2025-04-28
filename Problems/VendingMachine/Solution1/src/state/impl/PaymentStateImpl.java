package state.impl;

import dto.response.Change;
import data.CoinType;
import data.NoteType;
import dto.response.CoinChangeResponse;
import dto.response.NoteChangeResponse;
import state.PaymentState;
import vendingMachine.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class PaymentStateImpl implements PaymentState {
    @Override
    public void addCoin(VendingMachine vendingMachine, CoinType coinType) {
        vendingMachine.getVendingMachineData().addCoin(coinType);
    }

    @Override
    public void addNote(VendingMachine vendingMachine, NoteType noteType) {
        vendingMachine.getVendingMachineData().addNote(noteType);
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        vendingMachine.getInventoryProxy().addAllItems(vendingMachine.getVendingMachineData().getItems());
        vendingMachine.setState(new IdleStateImpl(vendingMachine));
    }

    @Override
    public Change returnChange(VendingMachine vendingMachine) {
        Change change = getBalanceAmount(vendingMachine);
        if(change == null) return change;
        changeToDispense(vendingMachine);
        return change;
    }

    private void changeToDispense(VendingMachine vendingMachine) {
        vendingMachine.setState(new DispenseStateImpl());
    }

    private Change getBalanceAmount(VendingMachine vendingMachine) {
        int targetAmount = vendingMachine.getVendingMachineData().getTotalAmountOfItems();
        int amountInCoinsAndNotes = vendingMachine.getVendingMachineData().getTotalAmount();
        if(amountInCoinsAndNotes < targetAmount) {
            System.out.println("Not enough amount.");
            return null;
        } else {
            if(targetAmount == amountInCoinsAndNotes) {
                System.out.println("No balance amount.");
                addCashFromVendingMachineData(vendingMachine);
                return new Change(new HashMap<>(), new HashMap<>());
            } else {
                int balanceAmount = amountInCoinsAndNotes - targetAmount;
                return getChange(vendingMachine, balanceAmount);
            }
        }
    }

    private Change getChange(VendingMachine vendingMachine, int balanceAmount) {
        NoteChangeResponse noteChangeResponse = vendingMachine.getCashProxy().getNoteChange(balanceAmount);
        balanceAmount -= noteChangeResponse.getAmount();
        CoinChangeResponse coinChangeResponse = vendingMachine.getCashProxy().getCoinChange(balanceAmount);
        balanceAmount -= coinChangeResponse.getAmount();

        Map<NoteType, Integer> noteChange = noteChangeResponse.getNotes();
        Map<CoinType, Integer> coinChange = coinChangeResponse.getCoins();

        if(balanceAmount != 0) {
            System.out.println("The change amount is not available now.");
            addCash(vendingMachine, coinChange, noteChange);
            return null;
        } else {
            System.out.println("Got change, adding the cash.");
            addCashFromVendingMachineData(vendingMachine);
            return new Change(coinChange, noteChange);
        }
    }

    private void addCashFromVendingMachineData(VendingMachine vendingMachine) {
        addCash(vendingMachine, vendingMachine.getVendingMachineData().getCoins(), vendingMachine.getVendingMachineData().getNotes());
    }

    private void addCash(VendingMachine vendingMachine, Map<CoinType, Integer> coins, Map<NoteType, Integer> notes) {
        addCoins(vendingMachine, coins);
        addNotes(vendingMachine, notes);
    }

    private void addCoins(VendingMachine vendingMachine, Map<CoinType, Integer> coins) {
        vendingMachine.getCashProxy().addCoins(coins);
    }

    private void addNotes(VendingMachine vendingMachine, Map<NoteType, Integer> notes) {
        vendingMachine.getCashProxy().addNotes(notes);
    }
}
