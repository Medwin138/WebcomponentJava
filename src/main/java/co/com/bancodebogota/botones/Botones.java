package co.com.bancodebogota.botones;

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

public class Botones {


    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public Botones(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }


    static String clickBtnNormal = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__viewfinder > div.bdb-component-viewer__content__viewfinder__body > div > div > button\")";
    static String clickBtnRdioSecundario = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(1) > bdb-radio > div:nth-child(2) > div.bdb-radio__circle > div\")";
    static String clickBtnRdioTerciario = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(1) > bdb-radio > div:nth-child(3) > div.bdb-radio__circle > div\")";
    static String clickBtnRdioIcono = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(2) > bdb-radio > div:nth-child(2) > div.bdb-radio__circle > div\")";
    static String clickBtnRdioFlecha = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(2) > bdb-radio > div:nth-child(3) > div.bdb-radio__circle > div\")";
    static String clickBtnRdioTamanoGrande = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(3) > bdb-radio > div:nth-child(1) > div.bdb-radio__circle > div\")";
    static String clickBtnRdioTamanoNormal = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(3) > bdb-radio > div:nth-child(2) > div.bdb-radio__circle > div\")";
    static String clickBtnRdioTamanoPequeno = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(3) > bdb-radio > div:nth-child(3) > div.bdb-radio__circle > div\")";
    static String clickChekboxInactivo = "return document.querySelector(\"div.bdb-component-viewer__content > div.bdb-component-viewer__content__options > div > div:nth-child(4) > bdb-checkbox > div > div.bdb-checkbox__square > div\")";

    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }

    public void clickBtnNormal() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnNormal)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Normal");
    }

    public void clickBtnRdioSecundario() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioSecundario)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Secundario");
    }

    public void clickBtnRdioTerciario() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioTerciario)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio terciario");
    }

    public void clickBtnRdioIcono() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioIcono)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Icono");
    }

    public void clickBtnRdioFlecha() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioFlecha)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Flecha");
    }

    public void clickBtnRdioTamanoGrande() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioTamanoGrande)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Tamaño Grande");
    }

    public void clickBtnRdioTamanoNormal() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioTamanoNormal)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Tamaño Normal");
    }

    public void clickBtnRdioTamanoPequeno() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickBtnRdioTamanoPequeno)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Tamaño Pequeño");
    }

    public void clickChekboxInactivo() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver)
                        .executeScript(clickChekboxInactivo)))
                .click();
        test.log(LogStatus.INFO, "Click en el Btn chekbox Inactivo");
    }

    public boolean isBtnRdioSecundarioSelected() {
        // Suponiendo que radioBtnSecundario es un WebElement que representa el botón de radio
        WebElement radioBtnSecundario = (WebElement) driver.findElements(By.id(clickBtnRdioSecundario));

        // Esperar a que el botón de radio sea visible
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(radioBtnSecundario));

        // Obtener el estado seleccionado del botón de radio
        boolean isRadioSelected = radioBtnSecundario.isSelected();

        if (isRadioSelected) {
            test.log(LogStatus.INFO, "El botón de radio está seleccionado");
        } else {
            test.log(LogStatus.INFO, "El botón de radio NO está seleccionado");
        }

        return isRadioSelected;
    }
}
