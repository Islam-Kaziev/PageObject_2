package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComonent;
import pages.components.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComonent calendarComonent = new CalendarComonent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
        private final String TITLE_TEXT = "Student Registration Form";
        private final SelenideElement   firstNameInput = $("#firstName"),
                                        lastNameInput = $("#lastName"),
                                        emailInput = $("#userEmail"),
                                        genderInput = $("#genterWrapper"),
                                        phoneInput = $("#userNumber"),
                                        subjectInput = $("#subjectsInput"),
                                        hobbiesInput = $("label[for=hobbies-checkbox-1]"),
                                        imageUpload = $("#uploadPicture"),
                                        currentAddressInput =  $("#currentAddress"),
                                        stateInput = $("#state"),
                                        cityInput = $("#city"),
                                        submitButton = $("#submit");
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComonent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.shouldHave(text(value)).click();

        return this;
    }

    public RegistrationPage setPicture(File value) {
        imageUpload.uploadFile(value);

        return this;
    }

    public RegistrationPage setCurrenAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();

        return this;
    }
}