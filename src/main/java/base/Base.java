package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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
    public static WebDriverWait webWait;
    public static ExtentReports extent;
    public static ExtentSparkReporter reporter;

    public Base() {
        properties = new Properties();
        String settingsPath = "./src/main/java/config/settings.properties";
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
        webWait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public static void closeInitialization() {
        driver.quit();
    }

    public static void reportSetUp() {
        String reportPath = System.getProperty("user.dir") + "/ExtentReports/reports2.html";
        reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Via.com Test Reports");
        reporter.config().setReportName("Automation TestNG Results on " + properties.getProperty("browser"));
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Alondra Elizabeth Delgadillo Silos");
        extent.setSystemInfo("Browser", properties.getProperty("browser"));
    }

    public void reportTearDown(){
        extent.flush();
    }
}
