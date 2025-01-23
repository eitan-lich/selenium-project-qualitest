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

    public void clickTitleButton() {
        click(titleRadioButton);
    }

    public void typePassword(String password) {
        typeText(passwordField, password);
    }

    public void selectBirthDay(String day) {
        dateOfBirthDayDropdown = new Select(find(dateOfBirthDay));
        dateOfBirthDayDropdown.selectByValue(day);
    }

    public void selectBirthMonth(String month) {
        dateOfBirthMonthDropdown = new Select(find(dateOfBirthMonth));
        dateOfBirthMonthDropdown.selectByVisibleText(month);
    }

    public void selectBirthYear(String year) {
        dateOfBirthYearDropdown = new Select(find(dateOfBirthYear));
        dateOfBirthYearDropdown.selectByValue(year);
    }

    public void clickSignupNewsletterCheckbox() {
        click(signupNewsletterCheckbox);
    }

    public void clickSpecialOffersCheckbox() {
        click(specialOffersCheckbox);
    }

    public void typeCompany(String company) {
        typeText(companyField, company);
    }

    public void typeFirstName(String firstName) {
        typeText(firstNameField, firstName);
    }

    public void typeLastNameField(String lastName) {
        typeText(lastNameField, lastName);
    }

    public void typeCompanyField(String company) {
        typeText(companyField, company);
    }

    public void typeAddress1(String address) {
        typeText(addressField1, address);
    }

    public void typeAddress2(String address) {
        typeText(addressField2, address);
    }

    public void selectCountry(String country) {
        countryFieldDropdown = new Select(find(countryField));
        countryFieldDropdown.selectByValue(country);
    }

    public void typeState(String state) {
        typeText(stateField, state);
    }

    public void typeCity(String city) {
        typeText(cityField, city);
    }

    public void typeZipCode(String zipcode) {
        typeText(zipcodeField, zipcode);
    }

    public void typeMobileNumber(String number) {
        typeText(mobileNumberField, number);
    }

    public void clickCreateAccountButton() {
        click(createAccountButton);
    }
}
