package Test.Selenium.pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FBClass implements FBInterface{

	private static WebDriver driver = null;
	String baseURL="https://www.facebook.com";
	String email = "deepayan.betal@yahoo.com";
	String password="Deepayan@7";
	
	String firstName= "";
	String lastName="";
	String mobileOremail="";
	String newPassword="";
	
	
	@Test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\Chromedriver83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		
	}

	@Test
	public void loginFb() {
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("u_0_b")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.linkText("VBScript"));

        //This will scroll the page Horizontally till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		
	}
	
	@Test
	public void createAccount() {

		driver.findElement(By.id("u_0_t")).sendKeys(firstName);
		driver.findElement(By.id("u_0_v")).sendKeys(lastName);
		driver.findElement(By.id("u_0_y")).sendKeys(mobileOremail);
		driver.findElement(By.id("u_0_13")).sendKeys(newPassword);
		
		Select days= new Select(driver.findElement(By.id("day")));
		days.selectByValue("10");
		
		Select months = new Select(driver.findElement(By.id("month")));
		months.selectByValue("Jan");
		
		Select years = new Select(driver.findElement(By.id("year")));
		years.selectByValue("1996");
		
		
		
		
		
	}
	
	

}
