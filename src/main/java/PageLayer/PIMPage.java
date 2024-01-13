package PageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilsLayer.Wait;

public class PIMPage extends BaseClass{
	String empID;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pimlink;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	private WebElement addEmpBtn;
	
	@FindBy(name="firstName")
	private WebElement fname;
	
	@FindBy(name="lastName")
	private WebElement lname;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//label[text()='Employee Id']/following::input[1]")
	private WebElement empId;
	
	@FindBy(xpath="//a[text()='Employee List']")
	private WebElement empList;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'][1]")
	private WebElement chkBox;
	
	@FindBy(xpath="//button[text()=' Delete Selected ']")
	private WebElement delBtn;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	private WebElement yesDelBtn;
	
	@FindBy(xpath="//span[text()='No Records Found']")
	WebElement noRecord;
	
	
	
	
	
	public PIMPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPimLink()
	{
		Wait.click(pimlink);
	}
	
	public void user_click_on_add_employee_button_and_enter_and_click_on_save_button(String Fname, String Lname)
	{
		Wait.click(addEmpBtn);
		Wait.sendKeys(fname, Fname);
		Wait.sendKeys(lname, Lname);
		Wait.click(saveBtn);
	}
	
	public String  user_capture_employee_id_and_click_on_employee_list()
	{
		 empID=empId.getAttribute("value");
		 Wait.click(empList);
		 return empID;
		 
	}
	
	public void enter_employee_id_and_click_on_search_button() throws InterruptedException
	{
		Thread.sleep(5000);
		Wait.sendKeys(empId, empID);
		Thread.sleep(5000);
		Wait.click(searchBtn);
		
	}
	
	public void select_the_search_employee_and_click_on_delete() throws InterruptedException
	{
		Thread.sleep(5000);
		//Wait.click(chkBox);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",chkBox );
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();",delBtn );
		//Wait.click(delBtn);
//		Thread.sleep(5000);
//		js.executeScript("arguments[0].click();",yesDelBtn );
		//Wait.click(yesDelBtn);
	}
	
	public void verify_employee_delete_or_not() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",yesDelBtn );
		//Wait.click(yesDelBtn);
//		Thread.sleep(5000);
//		Wait.sendKeys(empId, empID);
//		Thread.sleep(5000);
//		Wait.click(searchBtn);
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();",yesDelBtn );
//		String msg =noRecord.getText();
//	return msg;
		
		
		
	}
	
	
	
	
	
	

}
