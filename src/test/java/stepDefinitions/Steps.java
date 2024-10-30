package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.LoginPage;

public class Steps extends BaseClass  {
  
    
    @Given("User launch Chrome browser")
    public void user_launch_Chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When("User open URL {string}")
    public void user_open_URL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        lp.clickLogin();
        Thread.sleep(3000);
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) throws InterruptedException {
        if(driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.assertTrue("Login failed; message displayed.", false);
        } else {
            Assert.assertEquals("Page title does not match!", title, driver.getTitle());
            Thread.sleep(3000);
        }
    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000); // Consider replacing with WebDriverWait if synchronization issues persist
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
    
    //Customer feature step definitions.............
    
    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_Menu() {
        
    }

    @When("click on customers Menu Item")
    public void click_on_customers_Menu_Item() {
        
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() {
        
    }

    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        
    }

    @When("click on Save button")
    public void click_on_Save_button() {
        
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        
    }
}
