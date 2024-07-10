package produccion;

import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.alerts.BannerAlerts;
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
public class Alert {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    BannerAlerts alertas;
    String url = "https://sherpa.labdigitalbdbtvsstg.com/alert";

    BrowserStack brows;


    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        // driver = BrowserStack.iniciaBrowserstackWeb(caso);
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("Reporte_Exitoso");
        test = report.startTest(caso);
        alertas = new BannerAlerts(driver, test);
        driver.get(url);
        alertas.scrollElemet(0, 400);
    }

    @Test
    @XrayTest(key = "KWC-2684")
    public void testAlertClickEnTitulo() throws InterruptedException, IOException {
        alertas.clickTituloActivar();
        alertas.clickDesactivarTitulo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2685")
    public void testAlertClickBoton() throws InterruptedException, IOException {

        alertas.clickBotonActivar();
        ThreadSleep.thread(1000);
        alertas.clickBotonActivar();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2686")
    public void testAlertClickCerrar() throws InterruptedException, IOException {

        ThreadSleep.thread(1000);
        alertas.clickCerrarActivar();
        ThreadSleep.thread(1000);
        alertas.clickCerrarActivar();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2687")
    public void testAlertClickTituloExito() throws InterruptedException, IOException {

        alertas.clickExito();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2688")
    public void testAlertClickTituloInfo() throws InterruptedException, IOException {

        ThreadSleep.thread(3000);
        alertas.clickInfo();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2689")
    public void testAlertClickTituloAlert() throws InterruptedException, IOException {

        ThreadSleep.thread(3000);
        alertas.clickAlerta();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2690")
    public void testAlertClickTituloError() throws InterruptedException, IOException {

        ThreadSleep.thread(3000);
        alertas.clickError();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2691")
    public void testAlertClickTituloBotonActivar() throws InterruptedException, IOException {

        alertas.clickTituloconBotonActivar();
        ThreadSleep.thread(3000);
        alertas.clickExito();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2692")
    public void testAlertClickTituloBotonActivarInfo() throws InterruptedException, IOException {

        alertas.clickTituloconBotonActivar();
        ThreadSleep.thread(3000);
        alertas.clickInfo();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2693")
    public void testAlertClickTituloBotonActivarAlert() throws InterruptedException, IOException {

        alertas.clickTituloconBotonActivar();
        ThreadSleep.thread(3000);
        alertas.clickAlerta();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2694")
    public void testAlertClickTituloBotonActivarError() throws InterruptedException, IOException {

        alertas.clickTituloconBotonActivar();
        ThreadSleep.thread(3000);
        alertas.clickError();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2695")
    public void testAlertClickTituloBotonCerrarActivar() throws InterruptedException, IOException {


        alertas.clickTituloconBotonconCerrarActivar();
        ThreadSleep.thread(3000);
        alertas.clickExito();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2696")
    public void testAlertClickTituloBotonCerrarInfo() throws InterruptedException, IOException {

        alertas.clickTituloconBotonconCerrarActivar();
        ThreadSleep.thread(3000);
        alertas.clickInfo();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2697")
    public void testAlertClickTituloBotonCerrarAlert() throws InterruptedException, IOException {

        alertas.clickTituloconBotonconCerrarActivar();
        ThreadSleep.thread(3000);
        alertas.clickAlerta();
        takeScreenshot(driver, "testClickEnTitulo.png");
    }

    @Test
    @XrayTest(key = "KWC-2698")
    public void testAlertClickTituloBotonCerrarError() throws InterruptedException, IOException {

        alertas.clickTituloconBotonconCerrarActivar();
        ThreadSleep.thread(3000);
        alertas.clickError();
        takeScreenshot(driver, "testClickEnTitulo.png");
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
