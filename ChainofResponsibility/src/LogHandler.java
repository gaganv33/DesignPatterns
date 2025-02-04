public class LogHandler {
    private final Log log;

    public LogHandler(Log first, Log... chain) {
        this.log = Log.link(first, chain);
    }

    public void printLog(LogType type, String data) {
        log.handleLog(type, data);
    }
}
