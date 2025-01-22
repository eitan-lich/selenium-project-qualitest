package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupFormPage extends BasePage {

    private By enterAccountInformationHeader = By.xpath("//b[text()='Enter Account Information']");
    private By titleRadioButton = By.id("id_gender1");
    private By passwordField = By.id("password");
    private By dateOfBirthDay = By.id("days");
    private By dateOfBirthMonth = By.id("months");
    private By dateOfBirthYear = By.id("years");
    private By signupNewsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField1 = By.id("address1");
    private By addressField2 = By.id("address2");
    private By countryField = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    private Select countryFieldDropdown;
    private Select dateOfBirthDayDropdown;
    private Select dateOfBirthMonthDropdown;
    private Select dateOfBirthYearDropdown;

    public SignupFormPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPageLoaded() {
        return validateElementExist(enterAccountInformationHeader);
    }

    public void filloutForm() {
        countryFieldDropdown = new Select(find(countryField));
        dateOfBirthDayDropdown = new Select(find(dateOfBirthDay));
        dateOfBirthMonthDropdown = new Select(find(dateOfBirthMonth));
        dateOfBirthYearDropdown = new Select(find(dateOfBirthYear));

        click(titleRadioButton);
        typeText(passwordField, "Password123!");
        dateOfBirthDayDropdown.selectByValue("19");
        dateOfBirthMonthDropdown.selectByVisibleText("May");
        dateOfBirthYearDropdown.selectByValue("2000");
        click(signupNewsletterCheckbox);
        click(specialOffersCheckbox);
        typeText(firstNameField, "John");
        typeText(lastNameField, "Smith");
        typeText(companyField, "Company");
        typeText(addressField1, "Tel Aviv");
        typeText(addressField2, "Haifa");
        countryFieldDropdown.selectByValue("Israel");
        typeText(stateField, "Israel");
        typeText(cityField, "Tel Aviv");
        typeText(zipcodeField, "123444555");
        typeText(mobileNumberField, "00000000");
        click(createAccountButton);
    }
}
