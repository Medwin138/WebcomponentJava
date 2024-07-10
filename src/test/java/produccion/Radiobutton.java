package produccion;

import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.radiobutton.RadioB;
import co.com.bancodebogota.utlidades.BrowserStack;
import co.com.bancodebogota.utlidades.ExtendFactoryReports;
import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static co.com.bancodebogota.utlidades.Screenshots.takeScreenshot;

@Listeners({app.getxray.xray.testng.listeners.XrayListener.class})
public class Radiobutton {

    private WebDriver driver;
    private ExtentReports report;
    private ExtentTest test;
    private RadioB radio;
    private final String url = "https://sherpa.labdigitalbdbtvsstg.com/radiobutton";
    BrowserStack brows;

    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        // driver = BrowserStack.iniciaBrowserstackWeb(caso);
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("Reporte_Exitoso");
        test = report.startTest(caso);
        radio = new RadioB(driver, test);
        driver.get(url);
        radio.scrollElemet(0, 400);
    }

    @Test
    @XrayTest(key = "KWC-2679")
    public void testClickRadio1() throws InterruptedException, IOException {
        radio.scrollElemet(0, 400);
        radio.clickActivarRadioB1();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickRadio1.png");
    }


    @Test
    @XrayTest(key = "KWC-2681")
    public void testClickLabel() throws InterruptedException, IOException {
        radio.scrollElemet(0, 400);
        radio.clickActivarLabel();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickLabel.png");
    }

    @Test
    @XrayTest(key = "KWC-2682")
    public void testClickInactivo() throws InterruptedException, IOException {
        radio.scrollElemet(0, 400);
        radio.clickActivarInactivo();
        ThreadSleep.thread(1000);
        radio.clickActivarInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickInactivo.png");
    }

    @Test
    @XrayTest(key = "KWC-2683")
    public void testClickHorizontal() throws InterruptedException, IOException {
        radio.scrollElemet(0, 400);
        radio.clickActivarHorizontal();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickHorizontal.png");
    }

    @Test
    @XrayTest
    public void testClickVertical() throws InterruptedException, IOException {
        radio.scrollElemet(0, 400);
        radio.clickActivarVertical();
        takeScreenshot(driver, "testClickVertical.png");
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
