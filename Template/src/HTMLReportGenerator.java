public class HTMLReportGenerator extends ReportGenerator {
    @Override
    public void openFile() {
        System.out.println("Opening HTML Report");
    }

    @Override
    public String extractDataFromReport() {
        return "HTML: data";
    }

    @Override
    public void closeFile() {
        System.out.println("Closing HTML Report");
    }
}
