package co.com.bancodebogota.utlidades;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStack {

    static JavascriptExecutor jse;
    static WebDriver driver;
    public static final String USERNAME = "edwin218";
    public static final String AUTOMATE_KEY = "zzWSRatZG7FE3moSgpxr";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private BrowserStack() {
        throw new IllegalStateException("Utility class");
    }


    public static WebDriver iniciaBrowserstackWeb(String name) throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "108.0");
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("projectName", "ValDispositivos_WebComponent");
        browserstackOptions.put("buildName", "WebComponent_E2E");
        browserstackOptions.put("sessionName", name);
        browserstackOptions.put("geoLocation", "CO");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
        driver.manage().window().maximize();
        return driver;
    }


    public static WebDriver dispositivosPrueba(String dT, String dM, String testName) throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();

        String browserName = "browserName";
        String deviceName = "deviceName";
        String realMobile = "realMobile";
        String osVersion = "osVersion";
        String browserVersion = "browserVersion";
        String rBrowserName = "chrome";
        String rRealMobile = "true";
        String rbrowserVersion = "latest";
        String osVersion11 = "12.0";
        String osVersion13 = "12.0";
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("geoLocation", "CO");
        if (dM.equals("Celular")) {
            if (dT.equals("1")) {
                caps.setCapability(deviceName, "Samsung Galaxy S22 Ultra");
                caps.setCapability(osVersion, osVersion11);
            } else if (dT.equals("5")) {
                caps.setCapability(deviceName, "Samsung Galaxy Tab S9");
                caps.setCapability(osVersion, osVersion13);
            } else if (dT.equals("6")) {
                caps.setCapability(deviceName, "iPhone 12 Pro Max");
                caps.setCapability(osVersion, "16");
                caps.setCapability(browserVersion, rbrowserVersion);
            }
            caps.setCapability(realMobile, rRealMobile);
            caps.setCapability(browserName, rBrowserName);
        } else {
            if (dM.equals("MAC")) {
                caps.setCapability(browserName, rBrowserName);
                caps.setCapability("os", "OS X");
                caps.setCapability(osVersion, "Monterey");
                caps.setCapability(browserVersion, rbrowserVersion);
            } else {
                if (dM.equals("")) {
                    caps.setCapability(browserName, rBrowserName);
                    caps.setCapability("os", "Windows");
                    caps.setCapability(osVersion, "11");
                    caps.setCapability(browserVersion, rbrowserVersion);
                }
            }
        }

        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.idleTimeOut", "8000");
        caps.setCapability("sessionName", testName); // test name
        caps.setCapability("buildName", "WebComponent_E2E"); // CI/CD job or build name
        caps.setCapability("projectName", "ValDispositivos_WebComponent");
        caps.setCapability("browserstack.timezone", "Bogota");
        caps.setCapability("bstack:options", browserstackOptions);

        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().window().maximize();

        return driver;
    }

    public static void markTestStatus(String status, String reason, WebDriver driver) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}}");
    }

}
