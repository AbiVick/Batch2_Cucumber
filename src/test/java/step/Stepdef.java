package step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;
import pages.AddCustomerPage;
import pages.LoginPage;
import pages.SearchCustomerPage;

public class Stepdef extends BaseClass
{
	
	
	String email;
	
	
	@Before
	public void setup() throws IOException
	{
		//Logging
		logger=Logger.getLogger("nopCommerceDemoRun");
		PropertyConfigurator.configure("./testData/log4j.properties");
		logger.setLevel(Level.DEBUG);
		
		//Load properties file
		configProp= new Properties();
		FileInputStream configPropfile = new FileInputStream("./testData/config.properties");
		configProp.load(configPropfile);
		
		String br=configProp.getProperty("browser"); //getting the browser name from config.properties file
		
		//Launching browser
		if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		
		else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
			driver = new EdgeDriver();
		}
	
	}
	
	@BeforeStep
    public void executeTest(Scenario sc) {
        
        System.out.println("=================Execution is in Progress=========================");
        System.out.println(sc.getName());
        
    }
	
	//Login steps....................
	@Given("User launch chrome browser")
	public void user_Launch_Chrome_browser() {
		logger.info("************* Launching Browser *****************");
		
		
		
		lp=new LoginPage(driver);
		
		
		
		
		
	}

	@When("user open app URL {string}")
	public void user_opens_URL(String url) {
	logger.info("************* Opening URL  *****************");
	driver.get(url);
	 driver.manage().window().maximize();
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		logger.info("************* Prvding user and password *****************");
		
		
		//read data from excel
		
		
		
		
		lp.setUserName(email);
		lp.setPassword(password);
		
		
		
		
		
		
		
		
		logger.info("************* entered user and password on application $$$$*****************");
	
	
	
	
	
	
	
	
	}

	@When("click on Login")
	public void click_on_Login() {
		logger.info("************* click on login *****************");
	   lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_Title_should_be(String exptitle) throws InterruptedException {
	    
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			logger.info("************* Login failed *****************");
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("************* Login Passed *****************");
			Assert.assertEquals(exptitle, driver.getTitle());
		}
		Thread.sleep(3000);
		
	}

	@When("user click on Logout link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("************* clciking on logout *****************");
		lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("************* closing browser *****************");
	   driver.quit();
	}
	
	//Customer feature step definitions..........................................
	
	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
	  
		addCust=new AddCustomerPage(driver);
		
		
		
		
		
		logger.info("********* Verifying Dashboad page title after login successful **************");
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("********* Clicking on customer main menu **************");
		addCust.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("********* Clicking on customer sub menu **************");
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
		
		
		//read data from csv/text/excel or DB
		
		
		email = randomestring() + "_ibm@ibm.com";
		System.out.println("Email Value: " + email);
		
		Thread.sleep(5000);
		
		addCust.setEmail(email);
		
		Thread.sleep(5000);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' or 'Registered' customer role
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Rajesh");
		addCust.setLastName("Singh");
		addCust.setDob("7/05/1985"); // Format: D/MM/YYY
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing.........");
		
		
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		logger.info("********* Saving customer details **************");   
		addCust.clickOnSave();
		   Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

	//Searching customer by email ID.............................
	@When("Enter customer EMail")
	public void enter_customer_EMail() {
		searchCust=new SearchCustomerPage(driver);
		logger.info("********* Searching customer details by Email **************");
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		
		
		
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		//boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);

	
	
	
	
	}
	
	//steps for searching a customer by Name................
		@When("Enter customer FirstName")
		public void enter_customer_FirstName() {
			logger.info("********* Searching customer details by Name **************");
			searchCust=new SearchCustomerPage(driver);
			searchCust.setFirstName("Victoria");
		}

		@When("Enter customer LastName")
		public void enter_customer_LastName() {
			searchCust.setLastName("Terces");
		}

		@Then("User should found Name in the Search table")
		public void user_should_found_Name_in_the_Search_table() {
			boolean status=searchCust.searchCustomerByName("Victoria Terces");
			Assert.assertEquals(true, status);
		}
	
	
	
	
	
	
	
}
