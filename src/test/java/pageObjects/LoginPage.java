package pageObjects;
/*
@Owner : Swapnil Shete
This is Login Page Object Page
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    public WebDriver ldriver ;

    public LoginPage(WebDriver drv) {
        this.ldriver = drv ;
        PageFactory.initElements(drv, this);
    }

    @FindBy(id= "email")
    @CacheLookup
    WebElement eleEmail;

    @FindBy(id= "pass")
    @CacheLookup
    WebElement elePassWord;

    @FindBy(xpath= "//button[contains(@name, 'send')]")
    @CacheLookup
    WebElement eleBtnSend;

    @FindBy(xpath = "//span[contains(text(),'Welcome')]")
    @CacheLookup
    List<WebElement> txtWelcome;

    @FindBy(xpath = "//div[contains(text(), 'The account sign-in was incorrect')]")
    List<WebElement> txtError;


    public String getDashBoardMessage() {
       // System.out.println(txtWelcome.toString());
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(txtError));
        return txtWelcome.get(0).getText();
    }

    public String getErrorMessage() {
        return txtError.get(0).getText();
    }



    public void setEmail(String un) {
        eleEmail.sendKeys(un);
    }

    public void setPassWord(String pass) {
        elePassWord.sendKeys(pass);
    }

    public void clickLogin() {
        eleBtnSend.click();
    }
}
