package data;

public enum NoteType {
    FIVEHUNDRED(500), TWOHUNDRED(200), HUNDRED(100),
    FIFTY(50), TWENTY(20), TEN(10);

    private final int value;
    NoteType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
