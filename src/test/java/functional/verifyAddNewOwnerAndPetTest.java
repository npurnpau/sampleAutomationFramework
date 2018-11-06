/**
 * 
 */
package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindOwnersPage;
import pages.HomePage;
import pages.VeterinariansPage;
import testbase.TestBaseSetup;
import testbase.TestDataUtility;

/**
 * @author Naveen
 *
 */
public class verifyAddNewOwnerAndPetTest extends TestBaseSetup {
private WebDriver driver;
Map ownerDetails = new HashMap<String,String>();
Map petDetails = new HashMap<String,String>();
TestDataUtility testDataUtility = new TestDataUtility();

	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		ownerDetails.put("firstName", testDataUtility.getRandomString(10));
		ownerDetails.put("lastName", testDataUtility.getRandomString(10));
		ownerDetails.put("address", testDataUtility.getRandomString(10));
		ownerDetails.put("city", testDataUtility.getRandomString(10));
		ownerDetails.put("telephone", testDataUtility.getRandomTelephoneNumber());
		petDetails.put("petname",testDataUtility.getRandomString(10));
		petDetails.put("dataofbirth",testDataUtility.getRandomDate());
		petDetails.put("pettype","cat");
	}
	
	@Test
	public void verifyAddNewOwnderAndPet() throws Exception {
		HomePage homepage = new HomePage(driver);
		FindOwnersPage findOwnersPage = homepage.navigateToFindOwnersPage();
		// create a new owner
		findOwnersPage.createNewOwner(ownerDetails);
		// Add pet for the created owner
		findOwnersPage.addNewPet(petDetails);
		FindOwnersPage findOwnersPage2 = homepage.navigateToFindOwnersPage();
		// Verify created owner and pet details
		findOwnersPage2.verifyNewlyAddedOwnerAndPet(ownerDetails.get("lastName"), petDetails.get("dataofbirth"), petDetails.get("petname") );
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
