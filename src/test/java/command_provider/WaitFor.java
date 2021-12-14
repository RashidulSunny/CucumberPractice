package command_provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFor {
    private static final Logger LOGGER = LogManager.getLogger(WaitFor.class);
    WebDriver driver;
    private By locator;
    public WaitFor(WebDriver driver, By locator){
        this.driver = driver;
        this.locator = locator;

    }
    public WaitFor waitForElementLocated(){
        //explicit wait

        return this;
    }
    public WaitFor fixWait(Long ms) throws InterruptedException {
        try{
            Thread.sleep(ms);
        }catch (Exception e){
            LOGGER.error("The Exception is: " + e.getMessage());

        }
        return this;

    }
}
