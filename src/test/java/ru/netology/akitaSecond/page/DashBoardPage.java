package ru.netology.akitaSecond.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Selenide.*;

public class DashBoardPage extends AkitaPage {

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


    public DashBoardPage() {
        heading.shouldBe(Condition.visible);
    }

    public CreditCardPage cardOnePage() {
        buttonCardOne.click();
        CreditCardPage cardOne = new CreditCardPage();
        return page(CreditCardPage.class);
    }

    public CreditCardPage cardTwoPage() {
        buttonCardTwo.click();
        CreditCardPage cardTwo = new CreditCardPage();
        return page(CreditCardPage.class);
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

}