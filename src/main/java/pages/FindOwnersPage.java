package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import locators.FindOwnersLocators;
import locators.HomePageLocators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindOwnersPage extends FindOwnersLocators{

	private WebDriver driver;

	public FindOwnersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createNewOwner(Map<String, String > details){
		driver.findElement(add_owner_button).click();
		driver.findElement(first_name).sendKeys(details.get("firstName"));
		driver.findElement(last_name).sendKeys(details.get("lastName"));
		driver.findElement(address).sendKeys(details.get("address"));
		driver.findElement(city).sendKeys(details.get("city"));
		driver.findElement(telephone).sendKeys(details.get("telephone"));
		driver.findElement(add_owner_button_submit).click();
	}
	
	public void addNewPetForOwner() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(add_new_pet));
		driver.findElement(add_new_pet).click();
		
	}
	
	public void addNewPet(Map<String,String> petDetails) throws InterruptedException{
		driver.findElement(add_new_pet).click();
		driver.findElement(pet_name).sendKeys(petDetails.get("petname"));
		driver.findElement(pet_dateofbirth).sendKeys(petDetails.get("dataofbirth"));
		
		Select selectPetType = new Select(driver.findElement(pet_type));
		selectPetType.selectByVisibleText(petDetails.get("pettype"));
		
		driver.findElement(add_pet_submit).click();
	}
	
	public void verifyNewlyAddedOwnerAndPet(Object owner,Object dob, Object pet){
		driver.findElement(last_name).sendKeys(owner.toString());
		driver.findElement(find_owner_button).click();
		
		List<WebElement> actualDetails = driver.findElements(owner_pet_details);
			
			Assert.assertTrue(actualDetails.get(0).getText().equalsIgnoreCase(owner.toString()));
			Assert.assertTrue(actualDetails.get(1).getText().equalsIgnoreCase(dob.toString()));
			Assert.assertTrue(actualDetails.get(2).getText().equalsIgnoreCase(pet.toString()));
	
		
	}
	public ArrayList getAllExistingOwners() {
		ArrayList<String> ownersList = new ArrayList();
		List<WebElement> allVets = driver.findElements(owners);
		for (WebElement webElement : allVets) {
			ownersList.add(webElement.getText());
		}		
		return ownersList;
	}
	
	public boolean compareAllListOfExistingOwners(ArrayList<String> expected_owners){
		ArrayList<String> actual_vets = getAllExistingOwners();
		return actual_vets.containsAll(expected_owners);
	}
	
	public void navigateToFindOwnersPage(){
		driver.findElement(find_owner_button).click();
		
	}
	

	
}
