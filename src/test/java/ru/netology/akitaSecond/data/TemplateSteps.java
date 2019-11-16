package ru.netology.akitaSecond.data;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import lombok.val;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.netology.akitaSecond.page.DashBoardPage;
import ru.netology.akitaSecond.page.DashBoardPage2;
import ru.netology.akitaSecond.page.LoginPage;
import ru.netology.akitaSecond.page.VerificationPage;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static ru.alfabank.tests.core.helpers.PropertyLoader.loadProperty;

public class TemplateSteps {
    private final AkitaScenario scenario = AkitaScenario.getInstance();

    @Пусть("^пользователь залогинен с именем \"([^\"]*)\" и паролем \"([^\"]*)\"$")
    public void loginWithNameAndPassword(String login, String password) {
        val loginUrl = loadProperty("/application.properties");
        open(loginUrl);
        scenario.setCurrentPage(page(LoginPage.class));
        val LoginPage = (ru.netology.akitaSecond.page.LoginPage) scenario.getCurrentPage().appeared();
        val authInfo = new DataHelper.AuthInfo(login,password);
        scenario.setCurrentPage(LoginPage.validLogin(authInfo));
        val verificationPage = (VerificationPage) scenario.getCurrentPage().appeared();
        val verificationCode = DataHelper.getVerificationCode(authInfo);
        scenario.setCurrentPage(verificationPage.validVerify(verificationCode));
        scenario.getCurrentPage().appeared();
    }

    @Когда("^он переводит на свою карту \"([^\"]*)\" с карты номером \"([^\"]*)\" сумму \"([^\"]*)\"$ ")
    public void putCardAndAmountInfo(CreditCard card1, CreditCard card2, int amount) {
     //   val dashboardUrl = loadProperty("/application.properties");
      //  open(dashboardUrl);
        scenario.setCurrentPage(page(DashBoardPage.class));
        val dashboardPage = (DashBoardPage) scenario.getCurrentPage().appeared();
        val cardPageOne = dashboardPage.cardOnePage();
        cardPageOne.transferMoney(card1, card2, amount);
        scenario.setCurrentPage(cardPageOne.transferFromInfo(card2, amount));
        }

    @Тогда("^баланс его карты \"([^\"]*)\" из списка на главной странице должен стать \"([^\"]*)\"$ рублей")
    public void checkAmount(CreditCard cardOne, int amount) {
        val dashBoardPage2 = scenario.getPage(DashBoardPage2.class);
        assertEquals(dashBoardPage2.getBalanceFromPageCardOne(), cardOne.getBalance());
    }

}
