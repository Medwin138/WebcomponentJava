package co.com.bancodebogota.avatar;

import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Factoravatar {

    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public Factoravatar(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }


    static String clickNormal = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(1) > bdb-radio > div:nth-child(1) > div.bdb-radio__circle\")";
    static String clickIcono = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(1) > bdb-radio > div:nth-child(2) > div.bdb-radio__circle\")";
    static String clickImagen = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(1) > bdb-radio > div:nth-child(3) > div.bdb-radio__circle\")  ";


    static String clickTamanoGrande = "return  document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(2) > bdb-radio > div:nth-child(1) > div.bdb-radio__circle\") ";
    static String clickTamanoMediano = "return  document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(2) > bdb-radio > div:nth-child(2) > div.bdb-radio__circle\") ";
    static String clickTamanoPequeno = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(2) > bdb-radio > div:nth-child(3) > div.bdb-radio__circle\")  ";

    static String clickEstadoInactivo = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(3) > bdb-checkbox > div > div.bdb-checkbox__square\")";


    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }

    public void setClickNormalGrande() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickNormal)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoGrande)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo normal con tamaño grande");
    }

    public void setClickNormalMediano() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickNormal)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoMediano)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo mormal con tamaño mediano");
    }

    public void setClickNormalPequeno() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickNormal)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoPequeno)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo normal con tamaño pequeño");
    }

    public void setClickIconoGrande() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickIcono)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoGrande)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo icono con tamaño grande");
    }

    public void setClickIconoMediano() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickIcono)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoMediano)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo icono con tamaño mediano");
    }

    public void setClickIconoPequeno() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickIcono)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoPequeno)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo icono con tamaño pequeño");
    }

    public void setClickImagenGrande() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickImagen)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoGrande)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo imagen con tamaño grande");
    }

    public void setClickImagenMediano() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickImagen)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoMediano)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo imagen con tamaño mediano");
    }

    public void setClickImagenPequeno() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickImagen)))
                .click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickTamanoPequeno)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo imagen con tamaño pequeño");
    }

    public void setClickEstadoInactivo() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickEstadoInactivo)))
                .click();
        test.log(LogStatus.INFO, "Click en el tipo imagen con tamaño pequeño");
    }
}
