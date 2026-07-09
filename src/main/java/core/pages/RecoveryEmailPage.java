package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryEmailPage extends BasePage {
    private SelenideElement emailEntryField = $("[data-test-id='email-input']");
    private SelenideElement getCodeButton = $("[data-test-id='email-submit-btn']");

    {
        verifyPageElements();
    }

    @Step("Проверка элементов страницы")
    private void verifyPageElements() {
        emailEntryField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Set email address")
    public void setEmailAddress(String email) {
        emailEntryField.setValue(email);
    }

    @Step("Submit email address")
    public void submitEmailAddress() {
        getCodeButton.click();
    }
}
