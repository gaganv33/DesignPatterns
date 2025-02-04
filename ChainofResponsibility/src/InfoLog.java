public class InfoLog extends Log {
    @Override
    public boolean handleLog(LogType type, String data) {
        if(type.equals(LogType.INFO)) {
            System.out.println("[LOG]: " + data);
            return true;
        }
        return checkNext(type, data);
    }
}
