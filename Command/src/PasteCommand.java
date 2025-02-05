public class PasteCommand extends Command {
    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute(int start, int end) {
        if(checkIndex(start, end)) {
            return false;
        }
        StringBuilder text = editor.getText();
        StringBuilder copiedText = editor.getClipboard();

        int size = text.length();
        backup();

        if(start == end) {
            StringBuilder data;
            if(start == 0) {
                data = copiedText.append(text);
            } else if(start == size) {
                data = text.append(copiedText);
            } else {
                data = new StringBuilder(
                        text.substring(0, start) + copiedText + text.substring(start, size)
                );
            }
            editor.setText(data);
        } else {
            StringBuilder data;
            if(start == 0 && end == size) {
                data = copiedText;
            } else if(start == 0) {
                data = new StringBuilder(
                        copiedText + text.substring(end, size)
                );
            } else if(end == size) {
                data = new StringBuilder(
                        text.substring(0, start) + copiedText
                );
            } else {
                data = new StringBuilder(
                        text.substring(0, start) + copiedText + text.substring(end, size)
                );
            }
            editor.setText(data);
        }

        return true;
    }
}
