package co.com.bancodebogota.utlidades;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Scroll {
    WebDriver driver;

    public void scrollElement(int width, int high) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + width + "," + high + ")");
    }
}
