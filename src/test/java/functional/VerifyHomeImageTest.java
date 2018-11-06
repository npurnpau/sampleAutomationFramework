package functional;
/**
 * @author Naveen
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import testbase.TestBaseSetup;


public class VerifyHomeImageTest extends TestBaseSetup{
	private WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void CheckImage() throws Exception {
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verifyHomePageImage());
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}