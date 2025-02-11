public abstract class ReportGenerator {
    public abstract void openFile();
    public abstract String extractDataFromReport();
    public abstract void closeFile();

    public String generateGeneralReport(String data) {
        System.out.println("Generating general report");
        return ("Report: " + data);
    }

    public final void generateReport() {
        openFile();
        String data = extractDataFromReport();
        String generalReport = generateGeneralReport(data);
        System.out.println(generalReport);
        closeFile();
    }
}
