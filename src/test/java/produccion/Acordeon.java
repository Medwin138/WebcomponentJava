package produccion;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.acordeon.BloqueAcordeon;
import co.com.bancodebogota.utlidades.BrowserStack;
import co.com.bancodebogota.utlidades.ExtendFactoryReports;
import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.MalformedURLException;

import static co.com.bancodebogota.utlidades.Screenshots.takeScreenshot;

@Listeners({app.getxray.xray.testng.listeners.XrayListener.class})
public class Acordeon {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    BloqueAcordeon acordeon;
    String url = "https://sherpa.labdigitalbdbtvsstg.com/accordion";

    BrowserStack brows;


    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        // driver = BrowserStack.iniciaBrowserstackWeb(caso);
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("Reporte_Exitoso");
        test = report.startTest(caso);
        acordeon = new BloqueAcordeon(driver, test);
        driver.get(url);
        acordeon.scrollElemet(0, 400);
    }

    @Test
    @XrayTest(key = "KWC-2716")
    public void testAcordeonClickRadioIcono() throws InterruptedException, IOException {
        acordeon.clickRadioIconoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioIcono.png");
    }

    @Test
    @XrayTest(key = "KWC-2717")
    public void testAcordeonClickRadioDescripcion() throws InterruptedException, IOException {
        acordeon.scrollElemet(400, 400);
        acordeon.clickRadioDescripcionBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioDescripcion.png");
    }

    @Test
    @XrayTest(key = "KWC-2718")
    public void testAcordeonClickRadioTag() throws InterruptedException, IOException {
        acordeon.scrollElemet(400, 400);
        acordeon.clickRadioTagBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioTag.png");
    }

    @Test
    @XrayTest(key = "KWC-2719")
    public void testAcordeonClickRadioLabel() throws InterruptedException, IOException {
        acordeon.scrollElemet(400, 400);
        acordeon.clickRadioLabelBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioLabel.png");
    }

    @Test
    @XrayTest(key = "KWC-2720")
    public void testAcordeonClickRadioInactivo() throws InterruptedException, IOException {
        acordeon.clickRadioInactivoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioInactivo.png");
    }


    @Test
    @XrayTest(key = "KWC-2721")
    public void testAcordeonVariantesActivas() throws InterruptedException, IOException {
        acordeon.clickRadioTagBtn();
        acordeon.clickRadioLabelBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioInactivo.png");
    }

    @Test
    @XrayTest(key = "KWC-2722")
    public void testAcordeonVariantesInactivas() throws InterruptedException, IOException {
        acordeon.clickRadioTagBtn();
        acordeon.clickRadioLabelBtn();
        acordeon.clickRadioInactivoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioInactivo.png");
    }

    @Test
    @XrayTest(key = "KWC-2723")
    public void testAcordeonRadioIconoInactivo() throws InterruptedException, IOException {
        acordeon.clickRadioInactivoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioIconoInactivo.png");
    }

    @Test
    @XrayTest(key = "KWC-2724")
    public void testAcordeonRadioDescripcionInactivo() throws InterruptedException, IOException {
        acordeon.clickRadioInactivoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioDescripcionInactivo.png");
    }

    @Test
    @XrayTest(key = "KWC-2725")
    public void testAcordeonRadioTagInactivo() throws InterruptedException, IOException {
        acordeon.clickRadioTagBtn();
        acordeon.clickRadioInactivoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioTagInactivo.png");
    }

    @Test
    @XrayTest(key = "KWC-2726")
    public void testAcordeonRadioLabelInactivo() throws InterruptedException, IOException {
        acordeon.clickRadioLabelBtn();
        acordeon.clickRadioInactivoBtn();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testAcordeonClickRadioLabelInactivo.png");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "Text Pass");
            report.endTest(test);
            report.flush();
            BrowserStack.markTestStatus("passed", "Prueba exitosa", driver);
        } else {
            test.log(LogStatus.FAIL, "Text Fail");
            report.endTest(test);
            report.flush();
            BrowserStack.markTestStatus("failed", "Prueba fallida", driver);
        }
        driver.quit();
    }
}
