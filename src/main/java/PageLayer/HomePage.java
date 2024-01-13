package PageLayer;

import org.testng.Assert;

import BaseLayer.BaseClass;

public class HomePage extends BaseClass{
	
	public void homePageFunctionality()
	{
	
	String actualTitle=driver.getTitle();
	Assert.assertEquals(actualTitle.contains("HRM"), true);
	
	String actualUrl=driver.getCurrentUrl();
	Assert.assertEquals(actualUrl.contains("orangehrmlive"), true);

}
}
