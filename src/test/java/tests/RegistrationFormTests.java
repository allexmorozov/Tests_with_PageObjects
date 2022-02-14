package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Frost")
                .setUserEmail("alex@work.com")
                .clickGenderRadio()
                .setUserNumber("1234567890")
                .setBirthDate("9", "August", "1977")
                .setSubjectInput("hindi")
                .clickFirstHobbies()
                .clickOneMoreHobbies()
                .uploadPicture("raja.jpg")
                .setCurrentAddress("Lenina street 22")
                .selectStateDropdown()
                .selectCityDropdown()
                .clickSubmitButton()
                .checkForm();
    }
}

