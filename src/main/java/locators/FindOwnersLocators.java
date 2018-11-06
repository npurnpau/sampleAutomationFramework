package locators;

import org.openqa.selenium.By;

public class FindOwnersLocators {

	public By input_last_name = By.name("lastName");
	public By find_owner_button = By.xpath("//button[@type='submit']");
	public By add_owner_button = By.xpath("//a[text()='Add Owner']");
	public By add_owner_button_submit = By.xpath("//button[text()='Add Owner']");
	
	public By first_name = By.id("firstName");
	public By last_name = By.id("lastName");
	public By address = By.id("address");
	public By city = By.id("city");
	public By telephone = By.id("telephone");
	public By add_new_pet = By.xpath("//a[contains(text(),'Add')]");
	public By add_pet_submit = By.xpath("//button[contains(text(),'Add Pet')]");
	
	public By pet_name = By.id("name");
	public By pet_dateofbirth = By.id("birthDate");
	public By pet_type = By.xpath("//select[@id='type']");

	public By owners = By.xpath("//table[@id='vets']//tr//td[1]");
	public By owner_pet_details = By.xpath("//table[@class='table table-striped']//dd");
}
