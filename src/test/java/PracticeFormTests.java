import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    static File uploadedFile = new File("src/test/resources/demoC4t.jpg");
    String firstName = "Slim";
    String lastName = "Shady";
    String userEmail = "shady@home.com";
    String userPhone = "1234567890";
    String monthOfBirth = "July";
    String yearOfBirth = "1999";
    String dayOfBirth = "11";
    String subject = "Computer Science";
    String userAddress = "Myhome is on fire 55, ap 7";
    String userState = "NCR";
    String userCity = "Delhi";

    @BeforeAll
    public static void prepareBrowser() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue(userPhone);

        // Выбираем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth + ":not(.react-datepicker__day-outside-month)").click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(uploadedFile);
        $("#currentAddress").setValue(userAddress);

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#state").click();
        $("#stateCity-wrapper").$(byText(userState)).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText(userCity)).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name"), text(firstName + " " + lastName),
                text("Student Email"), text(userEmail),
                text("Gender"), text("Female"),
                text("Mobile"), text(userPhone),
                text("Date of Birth"), text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text("Subjects"), text(subject),
                text("Hobbies"), text("Reading"),
                text("Picture"), text("demoC4t.jpg"),
                text("Address"), text(userAddress),
                text("State and City"), text(userState + " " + userCity)
        );
    }
}