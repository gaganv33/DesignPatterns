public class CopyCommand extends Command {
    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute(int start, int end) {
        if(checkIndex(start, end)) {
            return false;
        }
        int size = editor.getText().length();
        if(start == end) {
            editor.setClipboard(0, size);
        } else {
            editor.setClipboard(start, end);
        }
        return false;
    }
}
