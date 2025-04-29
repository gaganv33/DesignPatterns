package processor;

import data.NoteType;

public class NoteProcessor extends CashProcessor {
    NoteProcessor(CashProcessor cashProcessor, NoteType noteType) {
        super(cashProcessor, noteType);
    }
}
