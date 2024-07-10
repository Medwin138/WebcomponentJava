package co.com.bancodebogota.radiobutton;

import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioB {

    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public RadioB(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }


    static String clickBtnRadio1 = "return document.querySelector(\"div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)\")";
    static String clickBtnRadio2 = "return document.querySelector(\"div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)\")";
    static String clickLabel = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(1) > bdb-checkbox > div > div.bdb-checkbox__square > div\")";
    static String clickInactivo = "return document.querySelector(\"bdb-component-viewer:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > bdb-checkbox:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)\")";
    static String clickHorizontal = "return document.querySelector(\"bdb-component-viewer:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > bdb-radio:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)\")";
    static String clickVertical = "return document.querySelector(\"bdb-component-viewer:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > bdb-radio:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)\")";


    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }

    public void clickActivarRadioB1() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnRadio1))).click();
        test.log(LogStatus.INFO, "Click en el RadioButton1");
    }

    public void clickActivarRadioB2() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnRadio2))).click();
        test.log(LogStatus.INFO, "Click en el RadioButton2");
    }

    public boolean isRadioB2Selected() {
        // Utiliza el método isSelected() de Selenium para verificar si el radio button está seleccionado
        return driver.findElement(By.id(clickBtnRadio2)).isSelected();
    }

    public void clickActivarLabel() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickLabel))).click();
        test.log(LogStatus.INFO, "Click en el Label");
    }

    public void clickActivarInactivo() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickInactivo))).click();
        test.log(LogStatus.INFO, "Click en el Estado inactivo");
    }

    public void clickActivarHorizontal() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickHorizontal))).click();
        test.log(LogStatus.INFO, "Click en el Estado horizontal");
    }

    public void clickActivarVertical() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickVertical))).click();
        test.log(LogStatus.INFO, "Click en el Estado horizontal");
    }

}
