package state.impl;

import atm.Atm;
import data.Card;
import state.IdleState;

public class IdleStateImpl implements IdleState {
    public IdleStateImpl(Atm atm) {
        atm.setCard(null);
    }

    @Override
    public void insertCard(Atm atm, Card card) {
        atm.setState(new HasCardImpl(atm, card));
    }
}
