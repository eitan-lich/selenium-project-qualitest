package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupFormPage extends BasePage {

    private By enterAccountInformationHeader = By.xpath("//b[text()='Enter Account Information']");
    private By titleRadioButton = By.id("id_gender1");
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By dateOfBirth = By.cssSelector("button[data-qa='create-account']");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By countryField = By.id("country");
    private Select countryFieldDropdown;
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    public SignupFormPage(WebDriver driver) {
        super(driver, 5000);
        countryFieldDropdown = new Select(find(countryField));
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(enterAccountInformationHeader);
    }

    public void filloutForm() {
        click(titleRadioButton);
        typeText(firstNameField, "testtest");
        typeText(lastNameField, "test222");
        typeText(companyField, "testcompany");
        typeText(addressField, "telaviv");
        countryFieldDropdown.selectByValue("Israel");
        typeText(cityField, "telaviv");
        typeText(zipcodeField, "123123123");
        typeText(mobileNumberField, "00000000000");
        click(createAccountButton);
    }
}