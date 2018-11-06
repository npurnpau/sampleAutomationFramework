package pages;



import locators.HomePageLocators;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends HomePageLocators{

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyHomePageImage() {
		WebElement ImageFile = driver.findElement(image_home);
	    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
	    return ImagePresent;
	}
	
	
	public VeterinariansPage navigateToVeterinariansPage(){
		driver.findElement(veterinarians_tab).click();
		return new VeterinariansPage(driver);
	}
	
	public FindOwnersPage navigateToFindOwnersPage(){
		driver.findElement(find_owners_tab).click();
		return new FindOwnersPage(driver);
	}
	
}
