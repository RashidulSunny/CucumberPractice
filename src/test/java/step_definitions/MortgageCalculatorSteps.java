package step_definitions;

import command_provider.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {

    WebDriver driver = Hooks.driver;
    public static Logger LOGGER = LogManager.getLogger(MortgageCalculatorSteps.class);


    @Given("^user is in mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageAppURL"));
        LOGGER.info("Landed on the mortgage calculator home page");

    }

    @Given("^user navigate to Real Apr page$")
    public void navigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
        LOGGER.info("Navigate to Real Apr Page");

    }

    @When("^user click on Calculate button upon entering the data$")
    public void clickOnCalculateButtonUponEnteringData(DataTable table) {
        List< Map<String, String> > data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : data){
            new RealApr(driver)
                    .typeHomePriceField(cells.get("HomePrice"))
                    .selectDollarSign()
                    .typeDownPaymentField(cells.get("DownPayment"))
                    .typeInterestRateField(cells.get("InterestRate"))
                    .clickCalculateButton();


        }
        LOGGER.info("Real Apr is calculated upon entering the data");

    }

    @Then("^the Real Apr is \"(.+?)\"$")
    public void validateRealAprRate(String realApr) {
        new RealApr(driver)
                .validateActualAprRate(realApr);
        LOGGER.info("Real Apr Rate is validated");

    }
}
