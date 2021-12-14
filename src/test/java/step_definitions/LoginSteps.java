package step_definitions;

import command_provider.ActOn;
import command_provider.AssertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    public static final By FullName = By.id("name");
    public static final By Password = By.id("password");
    public static final By Login = By.id("login");
    public static final By Logout = By.id("logout");
    public static final By InvalidPassword = By.xpath("//div[text()= 'Password is invalid']");
    public static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    public WebDriver driver = Hooks.driver;


    @Given("^user is on the login page$")
    public void navigateToLoginPage() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("TestAppURL"));

        LOGGER.info("User is in the login page");

    }

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
        ActOn.element(driver,FullName).setValues(username);
        ActOn.element(driver,Password).setValues(password);

        LOGGER.info("User has entered credentials");

    }

    @And("^click on login button$")
    public void clickOnLogin() {
        LOGGER.info("User clicked on login button");
        ActOn.element(driver,Login).click();

    }

    @When("^user click on login button using entering credentials$")
    public void userClickIOnLoginButtonUsingEnteringCredentials(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for(Map<String, String> cells: data){
            ActOn.element(driver,FullName).setValues(cells.get("username"));
            ActOn.element(driver,Password).setValues(cells.get("password"));
            LOGGER.info("User has entered credentials");

            ActOn.element(driver,Login).click();
            LOGGER.info("User clicked on login button");


        }

    }


    @Then("^user is navigated to home page$")
    public void validateUserIsLoggedInSuccessfully() {
        AssertThat.elementassertions(driver,Logout).elementDisplayed();
        LOGGER.info("User is in home page");
//        ActOn.browser(driver).closeBrowser();

    }

    @Then("^user is failed to login$")
    public void validateUnsuccessfulLogin(){
        AssertThat.elementassertions(driver,InvalidPassword).elementDisplayed();
        LOGGER.info("User is still on the login page");
//        ActOn.browser(driver).closeBrowser();

    }

}
