package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

public class PracticeFormWithPageObjects1Tests extends TestBase {

    static File uploadedFile = new File("src/test/resources/demoC4t.jpg");
    String firstName = "Slim";
    String lastName = "Shady";
    String userEmail = "shady@home.com";
    String userGender = "Female";
    String userPhone = "1234567890";
    String monthOfBirth = "July";
    String yearOfBirth = "1999";
    String dayOfBirth = "11";
    String subject = "Computer Science";
    String hobbie = "Reading";
    String userAddress = "Myhome is on fire 55, ap 7";
    String userState = "NCR";
    String userCity = "Delhi";

    @Test
    public void fillFormTest() {

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserPhone(userPhone)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobbie)
                .uploadFile(uploadedFile)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        formPage.verifySuccessModalWindow()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbie)
                .verifyResult("Picture", "demoC4t.jpg")
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}