package nguyentientho.java_call_jasper_report_;

import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PdfFromXmlFile {
    public static void main(String[] args) throws JRException {
        InputStream inputStream;
        JasperReport jasperReport = JasperCompileManager.compileReport("src\\main\\java\\jasper-template\\StyledTextReport.jrxml");

        Map<String, Object> parameters = new HashMap<>();

        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

//        File outputReport = new File("src\\main\\java\\jasper-template");

        JasperExportManager.exportReportToPdfFile(jasperPrint, "src\\main\\java\\jasper-template\\StyledTextReport.pdf");

        System.out.println("Complete export jasper report to pdf file");
    }
}
