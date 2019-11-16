package ru.netology.akitaSecond.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Selenide.*;

public class DashBoardPage2 extends AkitaPage {

    @FindBy(css = "[data-test-id=dashboard")
    @Name("Заголовок")
    private SelenideElement heading;


    @Name("Пополнить карта 1")
    private SelenideElement buttonCardOne = $$("[data-test-id=action]-deposit").first();

    @Name("Пополнить карта 2")
    private SelenideElement buttonCardTwo = $$("[data-test-id=action]-deposit").last();

    @Name("Баланс карта 1")
    private SelenideElement balanceCardOne = $$("li").first().$("div");

    @Name("Баланс карта 2")
    private SelenideElement balanceCardTwo = $$("li").last().$("div");

    @FindBy(css = "[data-test-id=error-notification]")
    @Name("Ошибка")
    private SelenideElement error;


    public DashBoardPage2() {
        heading.shouldBe(Condition.visible);
    }

    public CreditCardPage2 cardOnePage() {
        buttonCardOne.click();
        CreditCardPage2 cardOne = new CreditCardPage2();
        return page(CreditCardPage2.class);
    }

    public CreditCardPage2 cardTwoPage() {
        buttonCardTwo.click();
        CreditCardPage2 cardTwo = new CreditCardPage2();
        return page(CreditCardPage2.class);
    }


    public String getTextCardOne() {
        String [] text = balanceCardOne.innerText().substring(3).split(" ");
        String balance = text[5];
        return balance;
    }

    public int getBalanceFromPageCardOne() {
        int balanceAmount = Integer.parseInt(getTextCardOne());
        return balanceAmount;
    }

    public String getTextCardTwo() {
        String [] text = balanceCardTwo.innerText().substring(3).split(" ");
        String balance = text[5];
        return balance;
    }

    public int getBalanceFromPageCardTwo() {
        int balanceAmount = Integer.parseInt(getTextCardTwo());
        return balanceAmount;
    }

    public boolean errorIsVisible() {
        return error.is(Condition.visible);
    }

}


