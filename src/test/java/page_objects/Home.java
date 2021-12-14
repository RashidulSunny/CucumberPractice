package page_objects;

import command_provider.ActOn;
import command_provider.AssertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar{
    private final By HomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By DollarCheckBox = By.name("param[downpayment_type]");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By MonthCheckBox = By.name("param[start_month]");
    private final By YearInput = By.id("start_year");
    private final By TaxValue = By.id("pptytax");
    private final By PmiValue = By.id("pmi");
    private final By HomeInsurance = By.id("hoi");
    private final By MonthlyHoa = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By BuyInput = By.name("param[refiorbuy]");
    private final By CalculatorClink = By.name("cal");
    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver){
        super(driver);


    }
    public Home typeHomePrice(String value){
        LOGGER.debug("Typing The Home Price " + value);
        ActOn.element(driver, HomeValue).setValues(value);
        return this;

    }
    public Home typeDownPaymentPrice(String value){
        LOGGER.debug("Typing The DownPayment " + value);
        ActOn.element(driver, DownPayment).setValues(value);
        return  this;

    }
    public  Home clickDollarCheckBox(){
        LOGGER.debug("This is Dollar CheckBox ");
        ActOn.element(driver,DollarCheckBox).click();
        return  this;
    }
    public Home typeLoanAmount(String value){
        LOGGER.debug("This is Loan Amount " + value);
        ActOn.element(driver,LoanAmount).setValues(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("This is Interest Rate " + value);
        ActOn.element(driver,InterestRate).setValues(value);
        return this;
    }
    public Home typeLoanTerm(String value){
        LOGGER.debug("This is Loan Term " + value);
        ActOn.element(driver,LoanTerm).setValues(value);
        return this;
    }
    public  Home selectMonthCheckBox(String month){
        LOGGER.debug("This is Month CheckBox " + month);
        ActOn.element(driver,MonthCheckBox).selectValues(month);
        return  this;
    }
    public Home typeYear(String year){
        LOGGER.debug("This is Tear " + year);
        ActOn.element(driver,YearInput).setValues(year);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("This is Property Tax " + value);
        ActOn.element(driver,TaxValue).setValues(value);
        return this;
    }
    public Home typePmiValue(String value){
        LOGGER.debug("This is Pmi Value " + value);
        ActOn.element(driver,PmiValue).setValues(value);
        return this;
    }
    public Home typeHomeInsurance(String value){
        LOGGER.debug("This is Home Insurance " + value);
        ActOn.element(driver,HomeInsurance).setValues(value);
        return this;
    }
    public Home typeMonthlyHoa(String value){
        LOGGER.debug("This is Monthly HOA " + value);
        ActOn.element(driver,MonthlyHoa).setValues(value);
        return this;
    }
    public Home selectLoanType(String value){
        LOGGER.debug("This is Loan Type " + value);
        ActOn.element(driver,LoanType).selectValues(value);
        return this;
    }
    public Home selectBuy(String value){
        LOGGER.debug("This is Buy Input " + value);
        ActOn.element(driver,BuyInput).selectValues(value);
        return this;
    }
    public  Home clickCalculateButton(){
        LOGGER.debug("This is Calculate Button ");
        ActOn.element(driver,CalculatorClink).click();
        return  this;
    }
    public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment){

        //format expected value to string format because for change the value next time without change Xpath
        String formatXpath = String.format("//h3[contains(text(),'%s')]",expectedTotalMonthlyPayment);
        //showing expected value isDisplayed
        By monthlyPayment = By.xpath(formatXpath);
//        boolean present =  driver.findElement(monthlyPayment).isDisplayed();
//        Assert.assertTrue(present,"Total Monthly Payment is not presented");
        LOGGER.debug("Validating Total Monthly Payment is:  " + expectedTotalMonthlyPayment);

        AssertThat.elementassertions(driver,monthlyPayment).elementDisplayed();
        return this;
    }
}
