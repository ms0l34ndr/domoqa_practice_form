package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    GenderButton genderButton = new GenderButton();
    HobbiesCheckBox hobbiesCheckBox = new HobbiesCheckBox();
    ResultsModal successModalWindow = new ResultsModal();
    StateInput stateInput = new StateInput();
    CityInput cityInput = new CityInput();

    private final String TITLE_TEXT = "Student Registration Form";

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderButton.setGenderButton(value);

        return this;
    }

    public PracticeFormPage setUserPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesCheckBox.setHobbiesButton(value);

        return this;
    }

    public PracticeFormPage uploadFile(File file) {
        pictureInput.uploadFile(file);

        return this;
    }

    public PracticeFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateInput.setState(value);

        return this;
    }

    public PracticeFormPage setCity(String value) {
        cityInput.setCity(value);

        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public PracticeFormPage verifySuccessModalWindow() {
        successModalWindow.verifyModalAppears();

        return this;
    }

    public PracticeFormPage verifyResult(String key, String value) {
        successModalWindow.verifyResult(key, value);

        return this;
    }
}
