public abstract class Command {
    protected final Editor editor;
    protected StringBuilder backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    public void backup() {
        this.backup = editor.getText();
    }

    public void undo() {
        editor.setText(backup);
    }

    public boolean checkIndex(int start, int end) {
        int size = editor.getText().length();
        return (start < 0 || start >= size || end > size || end < 0);
    }

    public abstract boolean execute(int start, int end);
}
