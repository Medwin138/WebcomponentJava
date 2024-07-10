package co.com.bancodebogota.acordeon;

import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BloqueAcordeon {

    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public BloqueAcordeon(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    static String clickBtnRadioTag = "return document.querySelector(\"div.bdb-component-viewer__content__options--no-header bdb-checkbox > div:nth-child(3) .bdb-checkbox__square > div\")";
    static String clickBtnRadioLabel = "return document.querySelector(\"div.bdb-component-viewer__content__options--no-header bdb-checkbox > div:nth-child(4) .bdb-checkbox__square > div\")";
    static String clickBtnRadioInactivo = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(2) > bdb-checkbox > div > div.bdb-checkbox__square > div\")";
    static String clickBtnRadioIcono = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(1) > bdb-checkbox > div:nth-child(1) > div.bdb-checkbox__square > div\")";
    static String clickBtnRadioDescripcion = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options.bdb-component-viewer__content__options--no-header > div > div:nth-child(1) > bdb-checkbox > div:nth-child(2) > div.bdb-checkbox__square > div\")";


    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }


    public void clickRadioTagBtn() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRadioTag)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Tag");
    }

    public void clickRadioLabelBtn() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRadioLabel)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Label");
    }

    public void clickRadioInactivoBtn() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRadioInactivo)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Inactivo");
    }

    public void clickRadioIconoBtn() {
        WebElement radioIconoBtn = (WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnRadioIcono);

        if (radioIconoBtn.isSelected()) {
            test.log(LogStatus.INFO, "El botón Radio Icono ya está seleccionado. No se realizará ningún clic.");
        } else {
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(radioIconoBtn)).click();
            test.log(LogStatus.INFO, "Click en el Btn Radio Icono");
        }
    }

    public void clickRadioDescripcionBtn() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRadioDescripcion)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Descripcion");
    }
}
