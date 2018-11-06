package pages;

import java.util.ArrayList;
import java.util.List;

import locators.VeterinariansLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VeterinariansPage extends VeterinariansLocators {

	private WebDriver driver;

	public VeterinariansPage(WebDriver driver) {
		this.driver = driver;
	}
	public ArrayList getAllExistingVets() {
		ArrayList<String> vet_names = new ArrayList();
		List<WebElement> allVets = driver.findElements(vets);
		for (WebElement webElement : allVets) {
			vet_names.add(webElement.getText());
		}		
		return vet_names;
	}
	
	public boolean compareAllListOfExistingVets(ArrayList<String> expected_vets){
		ArrayList<String> actual_vets = getAllExistingVets();
		return expected_vets.containsAll(actual_vets);
	}
}
