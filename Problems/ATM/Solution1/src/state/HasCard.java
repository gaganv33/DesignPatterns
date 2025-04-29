package state;

import atm.Atm;

public interface HasCard extends State {
    boolean enterPin(Atm atm, String pin);
    void cancel(Atm atm);
}
