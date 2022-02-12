package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
                        .setUserNumber("1234567890");
       registrationPage.setBirthDate("9","August", "1977");

        registrationPage.clickFirstHobbies();
        registrationPage.clickOneMoreHobbies();
        registrationPage.uploadPicture("raja.jpg");
        registrationPage.setCurrentAddress("Lenina street 22");





        $("#subjectsInput").setValue("civics");
        $(byText("Civics")).click();
//        $(byText("Sports")).click();
//        $(byText("Music")).click();
//        $("#uploadPicture").uploadFromClasspath("raja.jpg");
//        $("#currentAddress").setValue("Lenina street 22");
        $("#stateCity-label").scrollTo();
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Alex"),
                text("Frost"),
                text("alex@work.com"),
                text("Male"),
                text("1234567890"),
                text("9 August,1977"),
                text("Civics"),
                text("Sports, Music"),
                text("Lenina street 22"),
                text("Haryana Karnal"));


    }
}

