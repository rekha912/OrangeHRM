package BaseLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public static void initialization(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("headless"))
		{
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			driver = new ChromeDriver(opt);
		}
		else if(browserName.equalsIgnoreCase("incognito"))
		{
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--incognito");
			driver = new ChromeDriver(opt);
		}
		else
		{
			System.err.println("please enter valid browserName");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)).pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		//String url =prop.getProperty("url");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	public BaseClass()
	{
		try
		{
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ConfigLayer\\confing.properties");
		 prop= new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}
