package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FlightPageTest;
import pages.HotelPageTest;
import pages.SearchFlightPageTest;
import pages.SearchHotelPageTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class Base {
    public static WebDriver driver;
    public static Properties properties;
    public static Actions actions;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public static FlightPageTest flightPageTest;
    public static SearchFlightPageTest searchFlightPageTest;
    public static HotelPageTest hotelPageTest;
    public static SearchHotelPageTest searchHotelPageTest;

    public Base() {
        properties = new Properties();
        String settingsPath = "./src/test/java/config/settings.properties";
        try {
            FileInputStream fis = new FileInputStream(settingsPath);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the properties file.");
        } catch (IOException e) {
            System.out.println("Cannot read the properties file.");
        }
    }

    public static void initialization() {
        switch (properties.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        WebElement cancel = driver.findElement(By.id("wzrk-cancel"));
        if (cancel.isDisplayed()) {
            cancel.click();
        }
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        flightPageTest = new FlightPageTest();
        searchFlightPageTest = new SearchFlightPageTest();
        hotelPageTest = new HotelPageTest();
        searchHotelPageTest = new SearchHotelPageTest();
    }

    public static void closeInitialization() {
        driver.quit();
    }
}
