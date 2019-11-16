package ru.netology.akitaSecond.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selenide.$;

public class CreditCardPage2 extends AkitaPage {
    @FindBy(css = "[data-test-id=dashboard")
    @Name("Заголовок")
    private SelenideElement heading;

    @FindBy(css = "[data-test-id=amount] input.input__control")
    @Name("Сумма")
    private SelenideElement amountField;

    @FindBy(css = "[data-test-id=from] input.input__control")
    @Name("Номер карты")
    private SelenideElement cardNumber;

    @FindBy(css = "[data-test-id=action-transfer]")
    @Name("Пополнить")
    private SelenideElement confirmButton;

    @FindBy(css = "[data-test-id=action-cancel]")
    @Name("Отмена")
    private SelenideElement cancellationButton;

    public CreditCardPage2() {
        heading.shouldBe(Condition.visible);
    }

    public boolean isEmpty() {
        return amountField.is(empty) && cardNumber.is(empty);
    }
}
