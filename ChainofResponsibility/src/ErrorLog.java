public class ErrorLog extends Log {
    @Override
    public boolean handleLog(LogType type, String data) {
        if(type.equals(LogType.ERROR)) {
            System.out.println("[ERROR]: " + data);
            return true;
        }
        return checkNext(type, data);
    }
}
