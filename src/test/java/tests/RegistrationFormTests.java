package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = "Alex";
    String userEmail = "alex@work.com";
    String userGender = "Male";
    String userNumber = "1234567890";
    String userDay = "9";
    String userMonth = "August";
    String userYear = "1977";
    String userSubject = "hindi";
    String userFile = "raja.jpg";
    String userHobby_1 = "Sports";
    String userHobby_2 = "Music";
    String userAddress = "Lenina street 22";
    String userState = "Haryana";
    String userCity = "Karnal";


    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .clickGenderRadio()
                .setUserNumber(userNumber)
                .setBirthDate(userDay, userMonth, userYear)
                .setSubjectInput(userSubject)
                .clickFirstHobbies()
                .clickOneMoreHobbies()
                .uploadPicture(userFile)
                .setCurrentAddress(userAddress)
                .selectStateDropdown()
                .selectCityDropdown()
                .clickSubmitButton()
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", userGender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", userDay + " " + userMonth + "," + userYear)
                .checkForm("Subjects", userSubject)
                .checkForm("Hobbies", userHobby_1 + ", " + userHobby_2)
                .checkForm("Address", userAddress)
                .checkForm("State and City", userState + " " + userCity);

    }
}


