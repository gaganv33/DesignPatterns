public class Main {
    public static void main(String[] args) {
        ReportGenerator pdfReportGenerator = new PDFReportGenerator();
        ReportGenerator csvReportGenerator = new CSVReportGenerator();
        ReportGenerator htmlReportGenerator = new HTMLReportGenerator();

        pdfReportGenerator.generateReport();
        csvReportGenerator.generateReport();
        htmlReportGenerator.generateReport();
    }
}