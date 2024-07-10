package produccion;


import app.getxray.xray.testng.annotations.XrayTest;
import co.com.bancodebogota.backdrop.AtomoBackdrop;
import co.com.bancodebogota.utlidades.BrowserStack;
import co.com.bancodebogota.utlidades.ExtendFactoryReports;
import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.Assert;
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
public class Backdrop {


    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    AtomoBackdrop back;
    String url = "https://sherpa.labdigitalbdbtvsstg.com/back-drop";
    BrowserStack brows;

    @BeforeMethod
    @Parameters({"Caso", "dT", "dM"})
    public void beforeMethod(String caso, String dT, String dM) throws MalformedURLException {
        // driver = BrowserStack.iniciaBrowserstackWeb(caso);
        driver = BrowserStack.dispositivosPrueba(dT, dM, caso);
        report = ExtendFactoryReports.getInstance("Reporte_Exitoso");
        test = report.startTest(caso);
        back = new AtomoBackdrop(driver, test);
        driver.get(url);
        back.scrollElemet(0, 400);

    }


    @Test
    @XrayTest(key = "KWC-2760")
    public void testClickActivarConAnimacion() throws InterruptedException, IOException {
        ThreadSleep.thread(5000);
        back.clickBotonAbrirBackDrop();
        ThreadSleep.thread(5000);
        takeScreenshot(driver, "BackdropConAnimacion.png");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Design System BdB";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test
    @XrayTest(key = "KWC-2761")
    public void testClickActivarSinAnimacion() throws InterruptedException, IOException {

        back.clickBtnRadiosinAnimacion();
        back.clickBotonAbrirBackDrop();
        ThreadSleep.thread(1000);
        takeScreenshot(driver, "BackdropSinAnimacion.png");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Design System BdB";
        Assert.assertEquals(expectedTitle, actualTitle);
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
