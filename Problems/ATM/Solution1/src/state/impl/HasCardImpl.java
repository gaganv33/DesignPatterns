package state.impl;

import atm.Atm;
import data.Card;
import state.HasCard;

public class HasCardImpl implements HasCard {
    public HasCardImpl(Atm atm, Card card) {
        atm.setCard(card);
    }

    @Override
    public boolean enterPin(Atm atm, String pin) {
        if(atm.getCard().checkIfPinIsMatching(pin)) {
            ifValidPin(atm);
            return true;
        }
        else {
            ifInValidPin(atm);
            return false;
        }
    }

    @Override
    public void cancel(Atm atm) {
        atm.setState(new IdleStateImpl(atm));
    }

    private void ifValidPin(Atm atm) {
        atm.setState(new ActiveStateImpl());
    }

    private void ifInValidPin(Atm atm) {
        atm.setState(new IdleStateImpl(atm));
    }
}
