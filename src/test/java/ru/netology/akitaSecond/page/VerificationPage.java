package ru.netology.akitaSecond.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.akitaSecond.data.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage extends AkitaPage {

   @FindBy(css = "[data-test-id=code] input.input__control")
   @Name("Код")
   private SelenideElement codeField;

   @FindBy(css = "[data-test-id=action-verify]")
   @Name("Продолжить")
   private SelenideElement verifyButton;

    public VerificationPage() {
        codeField.shouldBe(Condition.visible);
    }

    public DashBoardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return page(DashBoardPage.class);
    }

}
