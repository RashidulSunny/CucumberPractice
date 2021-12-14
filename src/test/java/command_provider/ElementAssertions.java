package command_provider;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ElementAssertions {
    WebDriver driver;
    private By locator;
    public ElementAssertions(WebDriver driver,By locator){
        this.driver = driver;
        this.locator = locator;

    }
    //create assertion (boolean condition) for element display
    public ElementAssertions elementDisplayed(){
        boolean display = driver.findElement(locator).isDisplayed();
        Assert.assertTrue("The Expected result does not displayed",display);
        return this;

    }
    //create assertion (boolean condition) for element clickable/enable for click
    public ElementAssertions elementClickable(){
        boolean enable = driver.findElement(locator).isEnabled();
        Assert.assertTrue("The Expected result does not clickable",enable);

        return this;
    }


}
