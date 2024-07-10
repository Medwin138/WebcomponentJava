package produccion;

import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.botones.Botones;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static co.com.bancodebogota.utlidades.Screenshots.takeScreenshot;

public class Button {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    Botones botones;
    String url = "https://sherpa.labdigitalbdbtvsstg.com/buttons";
    BrowserStack brows;


    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        //driver = BrowserStack.iniciaBrowserstackWeb(caso);
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("ReporteExitoso");
        test = report.startTest(caso);
        botones = new Botones(driver, test);
        driver.get(url);
        botones.scrollElemet(0, 500);


    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonNormal() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnNormal();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonNormal.png");
    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonNormalSecundario() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnNormal();
        ThreadSleep.thread(1000);
        botones.clickBtnRdioSecundario();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonNormalSecundario.png");
    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonNormalTerciario() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnNormal();
        ThreadSleep.thread(1000);
        botones.clickBtnRdioTerciario();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonNormalterciario.png");
    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonIcono() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnRdioIcono();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonIcono.png");
    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonFlecha() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnRdioIcono();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonFlecha.png");
    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonGrande() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnRdioTamanoGrande();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonTamañoGrande.png");
    }

    @Test
    @XrayTest(key = "")
    public void testClickBotonpequeno() throws InterruptedException, IOException {
        ThreadSleep.thread(1000);
        botones.clickBtnRdioTamanoPequeno();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickBotonTamañopequeño.png");
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
