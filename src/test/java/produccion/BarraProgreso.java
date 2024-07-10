package produccion;

import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.barra.Progressbar;
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
public class BarraProgreso {

    private WebDriver driver;
    private ExtentReports report;
    private ExtentTest test;
    private Progressbar progressbar;
    private final String url = "https://sherpa.labdigitalbdbtvsstg.com/progressbar";
    BrowserStack brows;


    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("Reporte_Exitoso");
        test = report.startTest(caso);
        progressbar = new Progressbar(driver, test);
        driver.get(url);
        progressbar.scrollElemet(0, 400);
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoBloqueada() throws InterruptedException, IOException {
        progressbar.clickRadioBtnBloqueada();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "clicBarraProgresoBloqueada.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoDesbloqueadaitems() throws InterruptedException, IOException {
        progressbar.clickRadioBtnDesbloqueada();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "clicBarraProgresoDesbloqueadaitems.png");
    }


    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoBloqueadaItems1() throws InterruptedException, IOException {
        progressbar.clickRadioBtnBloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems1();
        takeScreenshot(driver, "clicBarraProgresoBloqueada.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoBloqueadaItems2() throws InterruptedException, IOException {
        progressbar.clickRadioBtnBloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems2();
        takeScreenshot(driver, "clicBarraProgresoBloqueada.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoBloqueadaItems3() throws InterruptedException, IOException {
        progressbar.clickRadioBtnBloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems3();
        takeScreenshot(driver, "clicBarraProgresoBloqueada.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoBloqueadaItems4() throws InterruptedException, IOException {
        progressbar.clickRadioBtnBloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems4();
        takeScreenshot(driver, "clicBarraProgresoBloqueada.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoDesbloqueadaitems1() throws InterruptedException, IOException {
        progressbar.clickRadioBtnDesbloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems1();
        takeScreenshot(driver, "clicBarraProgresoDesbloqueadaitems1.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoDesbloqueadaitems2() throws InterruptedException, IOException {
        progressbar.clickRadioBtnDesbloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems2();
        takeScreenshot(driver, "clicBarraProgresoDesbloqueadaitems2.png");
    }

    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoDesbloqueadaitems3() throws InterruptedException, IOException {
        progressbar.clickRadioBtnDesbloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems3();
        takeScreenshot(driver, "clicBarraProgresoDesbloqueadaitems3.png");
    }


    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoDesbloqueadaitems4() throws InterruptedException, IOException {
        progressbar.clickRadioBtnDesbloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems4();
        takeScreenshot(driver, "clicBarraProgresoDesbloqueadaitems4.png");
    }


    @Test
    @XrayTest(key = "")
    public void clicBarraProgresoDesbloqueadaitems4step3() throws InterruptedException, IOException {
        progressbar.clickRadioBtnDesbloqueada();
        ThreadSleep.thread(1000);
        progressbar.clickListNumeroItems4();
        ThreadSleep.thread(1000);
        progressbar.clickBtnPaso3();
        takeScreenshot(driver, "clicBarraProgresoDesbloqueadaitems1step3.png");
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
