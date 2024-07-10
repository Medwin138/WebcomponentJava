package co.com.bancodebogota.alerts;

import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BannerAlerts {

    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public BannerAlerts(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[1]/bdb-checkbox/div[1]/div[1]/div")
    WebElement btn1;

    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[1]/bdb-checkbox/div[2]/div[1]/div")
    WebElement btn2;

    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[1]/bdb-checkbox/div[3]/div[1]/div")
    WebElement btn3;

    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[2]/bdb-radio/div[1]/div[1]/div")
    WebElement btnO1On;
    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[2]/bdb-radio/div[2]/div[1]/div")
    WebElement btnO2On;
    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[2]/bdb-radio/div[3]/div[1]/div")
    WebElement btnO3On;

    @FindBy(xpath = "/html/body/bdb-root/div/div/bdb-alert/div/div/div[2]/bdb-component-viewer/div[1]/div[1]/div[2]/div/div[2]/bdb-radio/div[4]/div[1]/div")
    WebElement btnO4On;


    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }

    public void clickDesactivarTitulo() throws InterruptedException {
        btn1.click();
        test.log(LogStatus.INFO, "Click en el boton para desactivar el titulo");
        ThreadSleep.thread(1000);
    }

    public void clickTituloActivar() throws InterruptedException {
        btn1.click();
        test.log(LogStatus.INFO, "Click en el boton 'Titulo' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickTituloconBotonActivar() throws InterruptedException {
        btn1.click();
        btn2.click();
        test.log(LogStatus.INFO, "Click en el boton 'Titulo con Boton' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickTituloconBotonconCerrarActivar() throws InterruptedException {
        btn1.click();
        btn2.click();
        btn3.click();
        test.log(LogStatus.INFO, "Click en el boton 'Titulo con Boton con Cerrar' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickBotonActivar() throws InterruptedException {
        btn2.click();
        test.log(LogStatus.INFO, "Click en el boton 'Boton' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickCerrarActivar() throws InterruptedException {
        btn3.click();
        test.log(LogStatus.INFO, "Click en el boton 'Cerrar' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickExito() throws InterruptedException {
        btnO1On.click();
        test.log(LogStatus.INFO, "Click en la opción 'Exito' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickInfo() throws InterruptedException {
        btnO2On.click();
        test.log(LogStatus.INFO, "Click en la opción 'Info' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickAlerta() throws InterruptedException {
        btnO3On.click();
        test.log(LogStatus.INFO, "Click en la opción 'Alert' para activar");
        ThreadSleep.thread(1000);
    }

    public void clickError() throws InterruptedException {
        btnO4On.click();
        test.log(LogStatus.INFO, "Click en la opción 'Error' para activar");
        ThreadSleep.thread(1000);
    }
}
