package ru.netology.akitaSecond.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.akitaSecond.data.CreditCard;

import javax.smartcardio.Card;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreditCardPage extends AkitaPage {
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


    public CreditCardPage() {
        heading.shouldBe(Condition.visible);
    }

    public DashBoardPage2 transferFromInfo(CreditCard card, int amount) {
        amountField.setValue(String.valueOf(amount));
        cardNumber.setValue(card.getNumber());
        confirmButton.click();
        return page(DashBoardPage2.class);
    }

    public DashBoardPage2 cancelRequest(CreditCard card, int amount) {
        amountField.setValue(String.valueOf(amount));
        cardNumber.setValue(card.getNumber());
        cancellationButton.click();
        return page(DashBoardPage2.class);
    }

    public void transferMoney(CreditCard card1, CreditCard card2, int amount) {
        int amountCard1 = card1.getBalance() + amount;
        card1.setBalance(amountCard1);
        int amountCard2 = card2.getBalance() - amount;
        card2.setBalance(amountCard2);
    }

    public void transferMoneyCheckingBalance(CreditCard card1, CreditCard card2, int amount) {
        int amountCard1 = card1.getBalance();
        int amountCard2 = card2.getBalance();
        if (amountCard2 >= amount) {
            amountCard1 = amountCard1 + amount;
            amountCard2 = amountCard2 - amount;
            card1.setBalance(amountCard1);
            card2.setBalance(amountCard2);
        } else {
            card1.setBalance(amountCard1);
            card2.setBalance(amountCard2);
        }

    }


}
