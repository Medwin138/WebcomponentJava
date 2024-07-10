package produccion;


import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.avatar.Factoravatar;
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
public class Avatar {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    Factoravatar avatar;
    String url = "https://sherpa.labdigitalbdbtvsstg.com/avatar";
    BrowserStack brows;

    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        //driver = BrowserStack.iniciaBrowserstackWeb(caso);
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("Reporte_Exitoso");
        test = report.startTest(caso);
        avatar = new Factoravatar(driver, test);
        driver.get(url);
        avatar.scrollElemet(0, 400);


    }

    @Test
    @XrayTest(key = "KWC-2699")
    public void testClickNormalGrande() throws InterruptedException, IOException {
        avatar.setClickNormalGrande();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickNormalGrande.png");
    }

    @Test
    @XrayTest(key = "KWC-2700")
    public void testClickNormalMediano() throws InterruptedException, IOException {
        avatar.setClickNormalMediano();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickNormalMediano.png");
    }

    @Test
    @XrayTest(key = "KWC-2701")
    public void testClickNormalPequeno() throws InterruptedException, IOException {
        avatar.setClickNormalPequeno();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickNormalPequeno.png");
    }

    @Test
    @XrayTest(key = "KWC-2702")
    public void testClickIconoGrande() throws InterruptedException, IOException {
        avatar.setClickIconoGrande();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickIconoGrande.png");
    }

    @Test
    @XrayTest(key = "KWC-2703")
    public void testClickIconoMediano() throws InterruptedException, IOException {
        avatar.setClickIconoMediano();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickIconoMediano.png");
    }

    @Test
    @XrayTest(key = "KWC-2703")
    public void testClickIconoPequeno() throws InterruptedException, IOException {
        avatar.setClickIconoPequeno();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickIconoPequeno.png");
    }

    @Test
    @XrayTest(key = "KWC-2705")
    public void testClickImagenGrande() throws InterruptedException, IOException {
        avatar.setClickIconoGrande();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenGrande.png");
    }

    @Test
    @XrayTest(key = "KWC-2706")
    public void testClickImagenMediano() throws InterruptedException, IOException {
        avatar.setClickImagenMediano();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenMediano.png");
    }

    @Test
    @XrayTest(key = "KWC-2707")
    public void testClickImagenPequeno() throws InterruptedException, IOException {
        avatar.setClickImagenPequeno();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenPequeno.png");
    }

    @Test
    @XrayTest(key = "KWC-2708")
    public void testClickNormalGrandeInactivo() throws InterruptedException, IOException {
        avatar.setClickNormalGrande();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenPequeno.png");
    }

    @Test
    @XrayTest(key = "KWC-2709")
    public void testClickNormalMedianoInactivo() throws InterruptedException, IOException {
        avatar.setClickNormalMediano();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickNormalMediano.png");
    }

    @Test
    @XrayTest(key = "KWC-2710")
    public void testClickNormalPequenoInactivo() throws InterruptedException, IOException {
        avatar.setClickNormalPequeno();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickNormalPequeno.png");
    }

    @Test
    @XrayTest(key = "KWC-2711")
    public void testClickIconoGrandeInactivo() throws InterruptedException, IOException {
        avatar.setClickIconoGrande();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickIconoGrande.png");
    }

    @Test
    @XrayTest(key = "KWC-2712")
    public void testClickIconoMedianoInactivo() throws InterruptedException, IOException {
        avatar.setClickIconoMediano();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickIconoMediano.png");
    }

    @Test
    @XrayTest(key = "KWC-2713")
    public void testClickIconoPequenoInactivo() throws InterruptedException, IOException {
        avatar.setClickIconoPequeno();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickIconoPequeno.png");
    }

    @Test
    @XrayTest(key = "KWC-2714")
    public void testClickImagenGrandeInactivo() throws InterruptedException, IOException {
        avatar.setClickIconoGrande();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenGrande.png");
    }

    @Test
    @XrayTest(key = "KWC-2715")
    public void testClickImagenMedianoInactivo() throws InterruptedException, IOException {
        avatar.setClickImagenMediano();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenMediano.png");
    }

    @Test
    @XrayTest(key = "KWC-2716")
    public void testClickImagenPequenoInactivo() throws InterruptedException, IOException {
        avatar.setClickImagenPequeno();
        ThreadSleep.thread(1000);
        avatar.setClickEstadoInactivo();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "testClickImagenPequeno.png");
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
