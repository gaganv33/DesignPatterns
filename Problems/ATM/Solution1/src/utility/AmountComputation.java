package utility;

import data.NoteType;

import java.util.Map;

public class AmountComputation {
    public static int getAmount(Map<NoteType, Integer> notes) {
        int totalAmount = 0;
        for(var entry : notes.entrySet()) {
            NoteType noteType = entry.getKey();
            int number = entry.getValue();
            totalAmount += (noteType.getValue() * number);
        }
        return totalAmount;
    }
}
