package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ApplyJobOnlinePageObject {

    @FindBy(how= How.XPATH, using="/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/a")
    public WebElement firstAvailableJobHyperlink;

    @FindBy(how= How.XPATH, using="/html/body/section[2]/div[2]/div/div/div/div/div[2]/div[1]/a")
    public WebElement ApplyOnlineButton;

    @FindBy(how= How.NAME, using="applicant_name")
    public WebElement InputFirstName;

    @FindBy(how= How.NAME, using="email")
    public WebElement InputEmail;

    @FindBy(how= How.NAME, using="phone")
    public WebElement InputPhone;

    @FindBy(how= How.NAME, using="message")
    public WebElement InputMessage;

    @FindBy(how= How.ID, using="wpjb_submit")
    public WebElement SubmitApplication;

}
