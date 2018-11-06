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
public class VerifyExistingVeterinariansTest extends TestBaseSetup {
private WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test
	public void verifyExistingVeterinarians() throws Exception {
		HomePage homepage = new HomePage(driver);
		VeterinariansPage veterinariansPage = homepage.navigateToVeterinariansPage();
		ArrayList<String> expected_vets = new ArrayList<String>(
			    Arrays.asList("James Carter","Helen Leary","Linda Douglas","Rafael Ortega","Henry Stevens","Sharon Jenkins"));
		Assert.assertTrue(veterinariansPage.compareAllListOfExistingVets(expected_vets));
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
