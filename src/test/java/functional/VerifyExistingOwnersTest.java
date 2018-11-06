/**
 * 
 */
package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindOwnersPage;
import pages.HomePage;
import pages.VeterinariansPage;
import testbase.TestBaseSetup;

/**
 * @author Naveen
 *
 */
public class VerifyExistingOwnersTest extends TestBaseSetup {
private WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void verifyAddNewOwnerTab() throws Exception {
		HomePage homepage = new HomePage(driver);
		FindOwnersPage findOwnersPage = homepage.navigateToFindOwnersPage();
		
		Assert.assertTrue(driver.findElement(findOwnersPage.input_last_name).isDisplayed());
		Assert.assertTrue(driver.findElement(findOwnersPage.find_owner_button).isDisplayed());
		Assert.assertTrue(driver.findElement(findOwnersPage.add_owner_button).isDisplayed());
		
		findOwnersPage.navigateToFindOwnersPage();
		
		ArrayList<String> expected_owners = new ArrayList<String>(
			    Arrays.asList("George Franklin","Betty Davis","Eduardo Rodriquez","Harold Davis","Peter McTavish","Jean Coleman","Jeff Black","Maria Escobito","David Schroeder","Carlos Estaban"));
		Assert.assertTrue(findOwnersPage.compareAllListOfExistingOwners(expected_owners));
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
