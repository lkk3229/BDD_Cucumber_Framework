package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.AddcustomerPage;
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
      addCust=new AddcustomerPage(driver);
      Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_Menu() throws InterruptedException {
    	Thread.sleep(3000);
    	addCust.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_Menu_Item() throws InterruptedException {
    	Thread.sleep(2000);
    	addCust.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
    	 addCust.clickOnAddnew();
    	 Thread.sleep(2000);
    }

    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
      Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());  
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
    	
    	String email = randomestring() + "@gmail.com";
        addCust.setEmail(email);
        addCust.setPassword("test123");
        // Registered - default
        // The customer cannot be in both 'Guests' and 'Registered' customer roles
        // Add the customer to 'Guests' or 'Registered' customer role
        addCust.setCustomerRoles("Guest");
        Thread.sleep(3000);

        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("Pavan");
        addCust.setLastName("Kumar");
        addCust.setDob("7/05/1985"); // Format: D/MM/YYY
        addCust.setCompanyName("busyQA");
        addCust.setAdminContent("This is for testing........."); 
    }

    @When("click on Save button")
    public void click_on_Save_button() {
        
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        
    }
}
