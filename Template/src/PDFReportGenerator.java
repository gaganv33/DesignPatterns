public class PDFReportGenerator extends ReportGenerator {
    @Override
    public void openFile() {
        System.out.println("Opening PDF Report");
    }

    @Override
    public String extractDataFromReport() {
        return "PDF: data";
    }

    @Override
    public void closeFile() {
        System.out.println("Closing PDF Report");
    }
}
