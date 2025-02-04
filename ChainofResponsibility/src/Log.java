public abstract class Log {
    protected Log log;

    public static Log link(Log first, Log... chain) {
        Log head = first;
        for(Log next : chain) {
            head.log = next;
            head = next;
        }
        return first;
    }

    public boolean checkNext(LogType type, String data) {
        if(log == null) {
            System.out.println("Invalid log type");
            return false;
        }
        return log.handleLog(type, data);
    }

    public abstract boolean handleLog(LogType type, String data);
}
