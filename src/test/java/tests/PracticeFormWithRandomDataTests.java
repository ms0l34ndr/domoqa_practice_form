package tests;

import org.junit.jupiter.api.Test;
import static testdata.RandomDataGenerator.*;

import java.io.File;

public class PracticeFormWithRandomDataTests extends TestBase {

    static String filename = getPicture();
    static File uploadedFile = new File("src/test/resources/" + filename);
    String firstName = getFirstName(),
         lastName = getLastName(),
         userEmail = getEmail(),
         userGender = getGender(),
         userPhone = getPhoneNumber(),
         monthOfBirth = getDateOfBirth()[1],
         yearOfBirth = getDateOfBirth()[2],
         dayOfBirth = getDateOfBirth()[0],
         subject = getSubject(),
         hobbie = getHobbie(),
         userAddress = getAddress(),
         userState = getState(),
         userCity = getCity(userState);

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
                .verifyResult("Picture", filename)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}