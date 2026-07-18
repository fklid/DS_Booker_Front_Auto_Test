package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $("[data-test-id='recovery-phone-btn']");
    private SelenideElement recoveryByEmailButton = $("[data-test-id= 'recovery-email-btn']");
    private SelenideElement goToSupportButton = $("[data-test-id='support-contact-btn']");
    private SelenideElement supportChat = $x("//div[@class='support-dialog']");
    private SelenideElement closeChatButton = $("[data-test-id='support-dialog-close']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }

    @Step("Открыть чат поддержки")
    public void referToSupport() {
        goToSupportButton.shouldBe(visible).click();
        supportChat.shouldBe(visible);
    }

    @Step("Закрыть чат поддержки")
    public void closeChat() {
        closeChatButton.shouldBe(visible).click();
    }

    @Step("Проверка закрытия чата")
    public void checkChatClosed() {
        supportChat.shouldNotBe(visible);
    }



}

