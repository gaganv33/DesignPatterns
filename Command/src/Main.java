public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Command copycommand = new CopyCommand(editor);
        Command cutCommand = new CutCommand(editor);
        Command pasteCommand = new PasteCommand(editor);

        editor.appendText(new StringBuilder("development"));
        editor.print();
        editor.execute(copycommand, 0, 7);
        editor.execute(pasteCommand, 0, 0);
        editor.print();
        editor.undo();
        editor.print();
        editor.execute(cutCommand, 0, 8);
        editor.print();
        editor.execute(pasteCommand, 0, 2);
        editor.print();
        editor.undo();
        editor.print();
    }
}