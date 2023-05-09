package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageWithPageObject extends TestBase {

    @Test
    void fillFormTest() {
        String userName = "Islam";
        String lastName = "Kaziev";
        String email = "Kaziev@mail.com";
        String gender = "Male";
        String firstSubject = "English";
        String secondSubject = "Chemistry";
        String hobby = "Sport";
        String image = "src/test/resources/images/мтс.png";
        File fileToUpload = new File(image);
        String phone = "9111111111";
        String currentAddress = "Pupkina, 214";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate("20", "July", "2007")
                .setSobject(firstSubject)
                .setSobject(secondSubject)
                .setHobbies(hobby)
                .setPicture(fileToUpload)
                .setCurrenAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", "20 " + "July" + "," + "2007")
                .verifyResult("Subjects", firstSubject + ", " + secondSubject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "мтс.png")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);

    }
}

