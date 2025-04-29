package processor;

import data.NoteType;

public class CashProcessorFactory {
    public static final CashProcessor cashProcessor;
    static {
        cashProcessor = new NoteProcessor(
                new NoteProcessor(
                        new NoteProcessor(
                                new NoteProcessor(
                                        new NoteProcessor(
                                                new NoteProcessor(null, NoteType.TEN
                                                ), NoteType.TWENTY
                                        ), NoteType.FIFTY
                                ), NoteType.HUNDRED
                        ), NoteType.TWOHUNDRED
                ), NoteType.FIVEHUNDRED
        );
    }
}
