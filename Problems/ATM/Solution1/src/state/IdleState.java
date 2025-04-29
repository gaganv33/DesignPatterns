package state;

import atm.Atm;
import data.Card;

public interface IdleState extends State {
    void insertCard(Atm atm, Card card);
}
