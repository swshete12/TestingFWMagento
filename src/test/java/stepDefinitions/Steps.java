package stepDefinitions;

import dev.failsafe.Execution;
import dev.failsafe.TimeoutExceededException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.time.Duration;

public class Steps {
    public WebDriver driver;
    public LoginPage lp ;

    @Given("User Launch Chrome browser")
    public void userLaunchChromeBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lp = new LoginPage(driver);
     }

    @When("User opens URL {string}")
    public void userOpensURL(String url) {
        try {
            driver.get(url);
            JavascriptExecutor jEx = (JavascriptExecutor)  driver;
            jEx.executeScript("window.scrollBy(100,600)");
        } catch(Exception to) {
            driver.close();
            Assert.assertTrue(to.getMessage(), false);
        }
    }


    @And("User enters Email as {string} and Password as {string}")
    public void userEntersEmailAsAndPasswordAs(String un, String pw) {
       lp.setEmail(un);
       lp.setPassWord(pw);
    }

    @And("Click on Login")
    public void clickOnLogin() {
       lp.clickLogin();
    }

    @Then("Landing Login content Should be {string}")
    public void LandingPageTitleShouldBe(String landingSucessfulMsg) throws InterruptedException {
        Thread.sleep(3000);
      try {
          if(driver.getTitle().contains("My Account") ) {
              Assert.assertTrue( "Welcome User : Dashboard" , lp.getDashBoardMessage().contains(landingSucessfulMsg));
          } else {
              Assert.assertTrue(false);
          }
      } catch ( Exception e) {
          driver.close();
          Assert.assertTrue(e.getMessage(), false);
         // System.out.println();
      }

    }

    @When("User click on Log Out link")
    public void userClickOnLogOutLink() {
        System.out.println("userClickOnLogOutLink");
    }

    @And("close")
    public void close() {
        driver.close();
    }

    @Then("Landing Page Should be on same page with alert message {string}")
    public void LandingPageShouldBeOnsamePage(String alerMsg) {
        try{

            Assert.assertTrue( "Welcome User : Dashboard" , lp.getErrorMessage().contains(alerMsg));
        }catch(Exception e){
            Assert.assertTrue(e.getMessage(), false);
        }
    }

}
