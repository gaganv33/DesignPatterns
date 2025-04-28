package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum NoteType {
    FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);
    private final int value;

    NoteType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static List<NoteType> getNoteTypeList() {
        return new ArrayList<>(Arrays.asList(HUNDRED, FIFTY, TWENTY, TEN, FIVE));
    }
}
