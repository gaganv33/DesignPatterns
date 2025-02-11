public class CSVReportGenerator extends ReportGenerator {
    @Override
    public void openFile() {
        System.out.println("Opening CSV Report");
    }

    @Override
    public String extractDataFromReport() {
        return "CSV: data";
    }

    @Override
    public void closeFile() {
        System.out.println("Closing CSV Report");
    }
}
