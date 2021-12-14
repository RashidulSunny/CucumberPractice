package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    //make it private, so it will not allow to create an object outside of this class. only create object in this class
    public DriverFactory(){
        //Empty Constructor
    }
    //create object
    public static final DriverFactory instance = new DriverFactory();
    //create a method
    public static DriverFactory getInstance(){
        return instance;
    }
    //create lambda expression using ThreadLocal which allow driver object to initialize chromedriver
    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() ->{
        String environment = System.getProperty("environment")== null ? "local" : System.getProperty("environment");
        String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        URL gridUrl = null;
        try {
           gridUrl = new URL(ReadConfigFiles.getPropertyValues("GridURL"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (environment.equals("remote") && browser.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            return new RemoteWebDriver(gridUrl,chromeOptions);
        }else if (environment.equals("remote") && browser.equals("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            return new RemoteWebDriver(gridUrl,firefoxOptions);

        }else if (environment.equals("remote") && browser.equals("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            return new RemoteWebDriver(gridUrl, edgeOptions);
        }else{

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();}
    });
    public WebDriver getDriver(){
        return driver.get();
    }
    //for kill driver end of the execution
    public void removeDriver(){
        driver.get().quit();
        driver.remove();

    }

}
