package co.com.bancodebogota.backdrop;

import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AtomoBackdrop {
    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public AtomoBackdrop(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }


    static String clickBtnRadioAnimacion = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div > bdb-radio > div:nth-child(1) > div.bdb-radio__circle > div\")";
    static String clickBtnRadioSinAnimacion = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div > bdb-radio > div:nth-child(2) > div.bdb-radio__circle > div\")";
    static String clickBtnAbrirBackDrop = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__viewfinder > div > div > div > button\")";
    static String clickBtnCerrarBackDrop = "return document.querySelector(\"div > div > bdb-backdrop > div > bdb-at-backdrop:nth-child(3) > div > button\")";

    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }


    public void clickActivarConAnimacion() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRadioAnimacion)))
                .click();

        test.log(LogStatus.INFO, "Click en el boton Activar Con Animacion");
    }

    public void clickBtnRadiosinAnimacion() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRadioSinAnimacion)))
                .click();

        test.log(LogStatus.INFO, "Click en el Btn Radio sin Animacion");
    }


    public void clickBotonAbrirBackDrop() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnAbrirBackDrop)))
                .click();

        test.log(LogStatus.INFO, "Click en el Boton Abrir BackDrop");
    }

    public void clickBotonCerrarBackDrop() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnCerrarBackDrop)))
                .click();

        test.log(LogStatus.INFO, "Click en el Boton Cerrar BackDrop");
    }
}
