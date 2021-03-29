package nguyentientho.java_call_jasper_report_;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JavaCallJasperReport {
    public static void main(String[] args) throws JRException, SQLException {

        String reportSrcFile = "src\\main\\java\\jasper-template\\FirstJasperReport.jrxml";

        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

        Connection conn = ConnectionUtils.getConnection();

        Map<String, Object> parameters = new HashMap<>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        exporter.setExporterInput(exporterInput);

        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                "src\\main\\java\\jasper-template\\FirstJasperReport.pdf");
        exporter.setExporterOutput(exporterOutput);

        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        System.out.println("Complete export PDF from Jasper report");
    }
}
