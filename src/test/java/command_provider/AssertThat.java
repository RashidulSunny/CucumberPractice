package command_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssertThat {


    public static ElementAssertions elementassertions(WebDriver driver, By locator){
        return new ElementAssertions(driver, locator);
    }
}
