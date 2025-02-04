public class WarningLog extends Log {
    @Override
    public boolean handleLog(LogType type, String data) {
        if(type.equals(LogType.WARNING)) {
            System.out.println("[WARNING]: " + data);
            return true;
        }
        return checkNext(type, data);
    }
}
