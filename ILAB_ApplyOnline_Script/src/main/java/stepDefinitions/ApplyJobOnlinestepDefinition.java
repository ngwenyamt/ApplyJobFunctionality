package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.ApplyJobOnlinePageObject;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ApplyJobOnlinestepDefinition {
    private ApplyJobOnlinePageObject apply_job_first_link;
    private ApplyJobOnlinePageObject click_apply_online_button;
    private ApplyJobOnlinePageObject input_first_name;
    private ApplyJobOnlinePageObject input_email;
    private ApplyJobOnlinePageObject input_phone;
    private ApplyJobOnlinePageObject input_message;
    private ApplyJobOnlinePageObject submit_application;

    public static WebDriver driver;
    @Given("^user navigate to the current job openings$")
    public void userNavigateToTheFirstAvailableJobHyperlink() {

        // launch the URL

        File file = new File(".\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try
        {
            driver.get("https://www.ilabquality.com/careers/south-africa/");
            Assert.assertTrue(true);
            Thread.sleep(6000);

        }
        catch (Exception e) {
            System.out.print("Unable to access the ILAB URL. server might be down");
            Assert.assertTrue(false);
            e.printStackTrace();

        }
    }

    @Then("^user select the first available job hyperlink$")
    public void userSelectTheFirstAvailableJobHyperlink() {
        apply_job_first_link = PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);

        try {

           apply_job_first_link.firstAvailableJobHyperlink.click();
           Assert.assertTrue(true);
           Thread.sleep(6000);

        }
        catch (Exception e)
        {
            System.out.print("Unable to find the first job hyperlink element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }
    }

    @And("^user click on Apply Online button$")
    public void userClickOnApplyOnlineButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1700)", "");
            Thread.sleep(5000);
            click_apply_online_button = PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);
            click_apply_online_button.ApplyOnlineButton.click();
            Assert.assertTrue(true);
            Thread.sleep(6000);
        }

        catch (Exception e)
        {
            System.out.print("Unable to find the Apply Online button element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^user input a first \"([^\"]*)\"$")
    public void userInputAFirst(String arg0){

        input_first_name = PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);

        try {

            input_first_name.InputFirstName.clear();
            input_first_name.InputFirstName.sendKeys(arg0);
            Assert.assertTrue(true);
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            System.out.print("Unable to find the first name element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^user input \"([^\"]*)\" address$")
    public void userInputAddress(String arg0){
        input_email = PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);

        try {

            input_email.InputEmail.clear();
            input_email.InputEmail.sendKeys(arg0);
            Assert.assertTrue(true);
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            System.out.print("Unable to find the email element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^user input phone number$")
    public void userInputPhoneNumber() {
        input_phone = PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);
        String randomNumbers = RandomStringUtils.randomNumeric(4);
        String phoneNumber = "071 567 "+ randomNumbers;
        try {

            input_phone.InputPhone.clear();
            input_phone.InputPhone.sendKeys(phoneNumber);
            Assert.assertTrue(true);
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            System.out.print("Unable to find the phone number element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^user input \"([^\"]*)\"$")
    public void userInput(String arg0) {
        input_message = PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);

        try {

            input_message.InputMessage.clear();
            input_message.InputMessage.sendKeys(arg0);
            Assert.assertTrue(true);
            Thread.sleep(2000);

        }
        catch (Exception e)
        {
            System.out.print("Unable to find the message element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }

    }

    @And("^user click on Send Application$")
    public void userClickOnSendApplication() {
        submit_application= PageFactory.initElements(driver, ApplyJobOnlinePageObject.class);

        try {

            submit_application.SubmitApplication.click();

            Thread.sleep(5000);

            if(driver.getPageSource().contains("You need to upload at least one file.")){
                Assert.assertTrue(true);
            }else {
                Assert.assertTrue(false);
                System.out.print("The text: ÿou need to upload at least one file does not exist");
            }

        }
        catch (Exception e)
        {
            System.out.print("Unable to find the phone number element");
            Assert.assertTrue(false);
            e.printStackTrace();
        }



    }
}
