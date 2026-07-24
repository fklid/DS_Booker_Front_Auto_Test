package core.pages.mobile;


import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MobileRecoveryEmailPage extends BasePage {
    private SelenideElement emailEntryField = $("[data-test-id='email-input']");
    private SelenideElement getCodeButton = $("[data-test-id='email-submit-btn']");
    private SelenideElement goBackButton = $("[data-test-id='btn-back']");


    {
        verifyPageElements();
    }

    @Step("Проверка элементов страницы")
    private void verifyPageElements() {
        emailEntryField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
        goBackButton.shouldBe(visible);
    }

    @Step("Ввод email адреса")
    public void setEmailAddress(String email) {
        emailEntryField.setValue(email);
    }

    @Step("Подтверждение email адреса")
    public void submitEmailAddress() {
        getCodeButton.click();
    }

    @Step("Переход по кнопке Назад")
    public void returnToPrevPage() {
        goBackButton.click();
    }

}
