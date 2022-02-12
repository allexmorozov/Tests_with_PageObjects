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
            userNameInput = $("#userNumber"),

            firstHobbiesCheckBox = $(byText("Sports")),
            thirdHobbiesCheckBox = $(byText("Music")),
            uploadPictureForm = $("#uploadPicture"),
            currentAddressField = $("#currentAddress");


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
        userNameInput.setValue(userNumber);
        return this;
    }
    public void setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

    }

    //
    public void clickFirstHobbies() {
        firstHobbiesCheckBox.click();
    }

    public void clickOneMoreHobbies() {
        thirdHobbiesCheckBox.click();
    }

    public void uploadPicture(String uploadPicture) {
        uploadPictureForm.uploadFromClasspath("raja.jpg");
    }

    public void setCurrentAddress(String currentAddress) {
        currentAddressField.setValue(currentAddress);
    }

}
