package ru.netology.akitaSecond.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.akitaSecond.data.*;

import static com.codeborne.selenide.Selenide.*;

@Name ("Стартовая страница")
public class LoginPage extends AkitaPage {

    @FindBy(css = "[data-test-id=login] input.input__control")
    @Name("Логин")
    private SelenideElement loginField;

    @FindBy(css = "[data-test-id=password] input.input__control")
    @Name("Пароль")
    private SelenideElement passwordField;

    @FindBy(css = "[data-test-id=action-login")
    @Name("Продолжить")
    private SelenideElement loginButton;


    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }
}