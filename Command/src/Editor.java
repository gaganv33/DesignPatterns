public class Editor {
    private StringBuilder text;
    private StringBuilder clipboard;
    private final CommandHistory commandHistory;

    public Editor() {
        this.text = new StringBuilder();
        this.clipboard = new StringBuilder();
        commandHistory = new CommandHistory();
    }

    public StringBuilder getText() {
        return this.text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public void appendText(StringBuilder data) {
        this.text.append(data);
    }

    public StringBuilder getClipboard() {
        return this.clipboard;
    }

    public void setClipboard(int start, int end) {
        this.clipboard = new StringBuilder(this.text.substring(start, end));
    }

    public void execute(Command command, int start, int end) {
        if(command.execute(start, end)) {
            commandHistory.push(command);
        }
    }

    public void undo() {
        if(!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        }
    }

    public void print() {
        System.out.println(this.text);
    }
}
