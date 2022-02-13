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
            subjectInput = $("#subjectsInput"),
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
    public RegistrationPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjectInput(String input){
       subjectInput.setValue(input);
        $(byText("Hindi")).click();
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
    public RegistrationPage selectStateDropdown(){
        $("#stateCity-label").scrollTo();
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        return this;
    }
    public RegistrationPage selectCityDropdown(){
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        return this;
    }
    public RegistrationPage clickSubmitButton(){
        $("#submit").click();
        return this;
    }
    public RegistrationPage checkForm(){
        $(".table-responsive").shouldHave(text("Alex"),
                text("Frost"),
                text("alex@work.com"),
                text("Male"),
                text("1234567890"),
                text("9 August,1977"),
                text("Hindi"),
                text("Sports, Music"),
                text("Lenina street 22"),
                text("Haryana Karnal"));
        return this;
    }

}
