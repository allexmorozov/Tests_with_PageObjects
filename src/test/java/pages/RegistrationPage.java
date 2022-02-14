package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private SelenideElement

            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $(byText("Male")),
            userNumberInput = $("#userNumber"),
            birthDateClick = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            subjectInputChoice = $(byText("Hindi")),
            firstHobbiesCheckBox = $(byText("Sports")),
            thirdHobbiesCheckBox = $(byText("Music")),
            uploadPictureForm = $("#uploadPicture"),
            currentAddressField = $("#currentAddress"),
            stateDropdownScroll = $("#stateCity-label"),
            stateDropdownClick = $(byText("Select State")),
            stateDropdownChoice = $(byText("Haryana")),
            cityDropdownClick = $(byText("Select City")),
            cityDropdownChoice = $(byText("Karnal")),
            submitButton = $("#submit"),
            checkFormField = $(".table-responsive");

    //action
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage clickGenderRadio() {
        genderRadioButton.click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateClick.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectInput(String input) {
        subjectInput.setValue(input);
        subjectInputChoice.click();
        return this;
    }

    public RegistrationPage clickFirstHobbies() {
        firstHobbiesCheckBox.click();
        return this;
    }

    public RegistrationPage clickOneMoreHobbies() {
        thirdHobbiesCheckBox.click();
        return this;
    }

    public RegistrationPage uploadPicture(String uploadPicture) {
        uploadPictureForm.uploadFromClasspath(uploadPicture);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressField.setValue(currentAddress);
        return this;
    }

    public RegistrationPage selectStateDropdown() {
        stateDropdownScroll.scrollTo();
        stateDropdownClick.click();
        stateDropdownChoice.click();
        return this;
    }

    public RegistrationPage selectCityDropdown() {
        cityDropdownClick.click();
        cityDropdownChoice.click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        checkFormField.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}
