package co.com.bancodebogota.barra;

import co.com.bancodebogota.utlidades.ThreadSleep;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Progressbar {

    WebDriver driver;
    ExtentTest test;
    ThreadSleep sleepThread;

    public Progressbar(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    static String clickBtnRadioBloqueada = "return document.querySelector(\"div[class='bdb-component-viewer__content__options__content'] div[class='bdb-radio__circle--check']\")";
    static String clickBtnRadioDesbloqueada = "return document.querySelector(\"div[class='bdb-component-viewer__content__options__content'] div[class='bdb-radio__circle--uncheck']\")";
    static String clickBtnEstandar = "return document.querySelector(\"#bdb-ml-secondtabs__2\")";
    static String clickBtnStep3 = "return document.querySelector(\"div:nth-child(1) > div:nth-child(2) > div:nth-child(3)\")";
    static String clickNroItems1 = "return document.querySelector(\"#dropdown_1\")";
    static String clickNroItems2 = "return document.querySelector(\"#dropdown_2\")";
    static String clickNroItems3 = "return document.querySelector(\"#dropdown_3\")";
    static String clickNroItems4 = "return document.querySelector(\"#dropdown_4\")";

    public void scrollElemet(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
        test.log(LogStatus.INFO, "Hizo el scroll");
    }


    public void clickRadioBtnBloqueada() {
        WebElement radioBtnBloqueada = (WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnRadioBloqueada);
        if (radioBtnBloqueada.isSelected()) {
            test.log(LogStatus.INFO, "El botón de radio Bloqueada ya está seleccionado. No se realizará ningún clic.");
        } else {
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(radioBtnBloqueada)).click();
            test.log(LogStatus.INFO, "Click en el botón de radio Bloqueada");
        }
    }

    public void clickRadioBtnDesbloqueada() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnRadioDesbloqueada))).click();
        test.log(LogStatus.INFO, "Click en el Btn Radio Des-Bloqueada");
    }

    public void clickBtnEstandar() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnEstandar))).click();
        test.log(LogStatus.INFO, "Click en el Btn Estandar para seleccionar variante del componente");
    }

    public void clickBtnPaso3() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickBtnStep3))).click();
        test.log(LogStatus.INFO, "Click para seleccionar el 3er paso");

    }

    public void clickListNumeroItems1() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickNroItems1))).click();
        test.log(LogStatus.INFO, "Click para seleccionar Nro de items 1");
    }

    public void clickListNumeroItems2() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickNroItems2))).click();
        test.log(LogStatus.INFO, "Click para seleccionar Nro de items 2");
    }

    public void clickListNumeroItems3() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickNroItems3))).click();
        test.log(LogStatus.INFO, "Click para seleccionar Nro de items 3");
    }

    public void clickListNumeroItems4() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((WebElement) ((JavascriptExecutor) driver).executeScript(clickNroItems4))).click();
        test.log(LogStatus.INFO, "Click para seleccionar Nro de items 4");
    }
}
