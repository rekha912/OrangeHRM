package Steps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import BaseLayer.BaseClass;
import PageLayer.HomePage;
import PageLayer.LoginPage;
import PageLayer.PIMPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseClass {
	LoginPage loginPage;
	PIMPage pIMPage;
	String empID;
	
	@Given("user open {string} and enter url")
	public void user_open_and_enter_url(String browserName)
	{
		BaseClass.initialization(browserName);
	}
	
	


	
	@When("enter valid username and password and click on login button")
	public void enter_valid_username_and_password_and_click_on_login_button(DataTable dataTable) {

		List<List<String>> ls =dataTable.asLists();  
		String Uname = ls.get(0).get(0);
		String Pass = ls.get(0).get(1);
		 loginPage = new LoginPage();
		loginPage.loginfunctionality(Uname, Pass);
		loginPage.clickOnLoginBtn();
		
	}

	
	@Then("verify home page title and url")
	public void verify_home_page_title_and_url() {
		HomePage homePage =new HomePage();
		homePage.homePageFunctionality();
		
	}

//	When user click on pim link
	@When("user click on pim link")
	public void user_click_on_pim_link()
	{
		 pIMPage=new PIMPage();
		pIMPage.clickOnPimLink();
	}
	
//	And validiate url 
	@When("validiate url")
	public void validiate_url(DataTable dataTable)
	{
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL.contains("pim"), true);
	}

//	And user click on add employee button and enter "<firstname>" , "<lastname>" and click on save button
	
	@When("user click on add employee button and enter {string} , {string} and click on save button")
	public void user_click_on_add_employee_button_and_enter_and_click_on_save_button(String Fname, String Lname) {
		 pIMPage.user_click_on_add_employee_button_and_enter_and_click_on_save_button(Fname, Lname);
	}
	
	
//	And user capture employee id and click on employee list
	@When("user capture employee id and click on employee list")
	public void user_capture_employee_id_and_click_on_employee_list()
	{
		 pIMPage.user_capture_employee_id_and_click_on_employee_list();
	}
//	And enter employee id and click on search button
	@When("enter employee id and click on search button")
	public void enter_employee_id_and_click_on_search_button() throws InterruptedException
	{
		pIMPage.enter_employee_id_and_click_on_search_button();
	}
//	And select the search employee and click on delete
	@When("select the search employee and click on delete")
	public void select_the_search_employee_and_click_on_delete() throws InterruptedException
	{
		pIMPage	.select_the_search_employee_and_click_on_delete();
	}
//	And verify employee delete or not
	@When("verify employee delete or not")
	public void verify_employee_delete_or_not() throws InterruptedException
	{
//		String msg = pIMPage.verify_employee_delete_or_not(empID);
//		Assert.assertEquals(msg.contains("No"), true);
		pIMPage.verify_employee_delete_or_not();
	}

	
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			byte [] f =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
			
			scenario.attach(f, "image/png", date+scenario.getName());
		}
	}

}
