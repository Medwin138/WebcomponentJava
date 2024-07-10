package co.com.bancodebogota.utlidades;

import com.relevantcodes.extentreports.ExtentReports;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendFactoryReports {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtendFactoryReports.class);

    private ExtendFactoryReports() {
        LOGGER.info("ExtendFactoryReports");
        throw new IllegalStateException("Utility class");
    }

    public static ExtentReports getInstance(String reporteAutomatizacion) {
        ExtentReports report;
        String path = "./reportes/" + reporteAutomatizacion + ".html";
        report = new ExtentReports(path, false);
        report
                .addSystemInfo("Versión de Selenium: ", "4.1.2")
                .addSystemInfo("Sistema Operativo: ", "Mac")
                .addSystemInfo("Objetivo: ", "Reporte de Libranzas");
        return report;
    }

}
