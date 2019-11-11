package ru.netology.akitaSecond.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.akitaSecond.data.*;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id=login] input.input__control");
    private SelenideElement passwordField = $("[data-test-id=password] input.input__control");
    private SelenideElement loginButton = $("[data-test-id=action-login");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }



}
