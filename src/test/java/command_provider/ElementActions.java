package command_provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ElementActions {
    //Logger object creation for use log inside method
    private static final Logger LOGGER = LogManager.getLogger(ElementActions.class);
    //declare class variable
    public By locator;
    WebDriver driver;
    //declare constructor method with two method parameter and initialized them using this clause
    public ElementActions(WebDriver driver,By locator){
        this.driver = driver;
        this.locator = locator;

    }
    public WebElement getElements(){

        //create an variable (element) which return type is WebElement and value declare null
        WebElement element = null;
        //use try catch for exception handling and initialize the value for element variable by findElement
        try {
            element = driver.findElement(locator);

        }catch (Exception e){
            //using LOGGER object for exception handling and shows the message
            LOGGER.error("Element Exception for locator: " + locator + "The Exception is: " + e.getMessage());
        }
        return element;

        }
        public ElementActions click(){
        getElements().click();
        return this;
        }

        public ElementActions setValues(String Values){
        getElements().clear();
        getElements().sendKeys(Values);
        return this;
        }
        public ElementActions selectValues(String Values){
            Select select = new Select(getElements());
            select.selectByVisibleText(Values);
            return this;

        }

        public ElementActions mouseHover(){
            Actions action = new Actions(driver);
            action.moveToElement(getElements()).perform();
            return this;
        }

        public String getTextValue(){
        return getElements().getText();

        }




}
