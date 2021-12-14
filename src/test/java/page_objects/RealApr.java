package page_objects;
import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//label[contains(text(),'Calculator')]");
    private final By HomePriceField = By.name("HomeValue");
    private final By DollarSignSelect = By.cssSelector("section.content-container:nth-child(2) section.content-area div.wrapper div.content-right div.cal-block div.cal-content div.tabsmain:nth-child(5) table.sortable:nth-child(1) tbody:nth-child(2) tr:nth-child(2) td:nth-child(2) > input:nth-child(1)");
    private final By DownPaymentField = By.name("DownPayment");
    private final By InterestRateField = By.name("Interest");
    private final By LengthField = By.name("Length");
    private final By DiscountPointsField = By.name("Points");
    private final By LoanFeesField = By.name("Origination");
    private final By ClosingCostField = By.name("Closing");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//strong[text()='Actual APR:']/../../td[2]/strong");
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);


    public RealApr(WebDriver driver){
        super(driver);

    }
    public RealApr waitForPageToLoad(){
        LOGGER.debug("Wait for Real APR Page to load: ");
        ActOn.wait(driver,CalculatorTab).waitForElementLocated();
        return this;

    }
    public RealApr typeHomePriceField(String value){
        LOGGER.debug("This is the Home Price: " + value);
        ActOn.element(driver,HomePriceField).setValues(value);
        return this;

    }
    public RealApr selectDollarSign(){
        LOGGER.debug("Click Dollar Sign: ");
        ActOn.element(driver,DollarSignSelect).click();
        return this;

    }
    public RealApr typeDownPaymentField(String value){
        LOGGER.debug("This is the Down Payment: " + value);
        ActOn.element(driver,DownPaymentField).setValues(value);
        return this;

    }
    public RealApr typeInterestRateField(String value){
        LOGGER.debug("This is the Interest Rate: " + value);
        ActOn.element(driver,InterestRateField).setValues(value);
        return this;

    }
    public RealApr typeLengthField(String value){
        LOGGER.debug("This is the Length: " + value);
        ActOn.element(driver,LengthField).setValues(value);
        return this;

    }
    public RealApr typeDiscountPointsField(String value){
        LOGGER.debug("This is the Discount Points: " + value);
        ActOn.element(driver,DiscountPointsField).setValues(value);
        return this;

    }
    public RealApr typeLoanFeesField(String value){
        LOGGER.debug("This is the Loan Fees: " + value);
        ActOn.element(driver,LoanFeesField).setValues(value);
        return this;

    }
    public RealApr typeClosingCostField(String value){
        LOGGER.debug("This is the Closing Cost: " + value);
        ActOn.element(driver,ClosingCostField).setValues(value);
        return this;

    }
    public RealApr clickCalculateButton(){
        LOGGER.debug("Click Calculate Button: ");
        ActOn.element(driver,CalculateButton).click();
        return this;

    }
    public RealApr validateActualAprRate(String expectedActualAprRate){
        LOGGER.debug("Validate Actual APR Rate is:  " + expectedActualAprRate);
        AssertThat.elementassertions(driver,ActualAprRate).elementDisplayed();
        return this;



    }





}


