public class CutCommand extends Command {
    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute(int start, int end) {
        if(checkIndex(start, end)) {
            return false;
        }
        StringBuilder text = editor.getText();
        int size = text.length();
        backup();

        if(start == end) {
            editor.setClipboard(0, size);
            editor.setText(new StringBuilder());
        } else {
            editor.setClipboard(start, end);
            StringBuilder data;
            if(start == 0 && end == size) {
                data = new StringBuilder();
            } else if(start == 0) {
                data = new StringBuilder(
                        text.substring(end, size)
                );
            } else if(end == size) {
                data = new StringBuilder(
                        text.substring(0, start)
                );
            } else {
                data = new StringBuilder(
                        text.substring(0, start) + text.substring(end, size)
                );
            }
            editor.setText(data);
        }
        return false;
    }
}
