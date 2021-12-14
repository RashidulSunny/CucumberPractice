package command_provider;

import org.openqa.selenium.WebDriver;



public class BrowserActions {
    //create driver object globally
    WebDriver driver;
    //create constructor method with method parameter
    public BrowserActions(WebDriver driver){
        this.driver = driver;

    }
    //create method according same class
    public BrowserActions openBrowser(String url){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }
    public BrowserActions closeBrowser(){
        driver.quit();
        return this;
    }
    public String captureTitle(){
        return driver.getTitle();
    }

}
