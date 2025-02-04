public class Main {
    public static void main(String[] args) {
        Log log = Log.link(new InfoLog(), new WarningLog(), new ErrorLog());
        LogHandler logHandler = new LogHandler(log);
        logHandler.printLog(LogType.INFO, "info log");
        logHandler.printLog(LogType.WARNING, "warning log");
        logHandler.printLog(LogType.ERROR, "error log");
    }
}