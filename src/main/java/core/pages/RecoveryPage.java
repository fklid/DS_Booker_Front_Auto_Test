package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


    public class RecoveryPage extends BasePage {

        private SelenideElement recoveryByPhoneButton = $("[data-test-id='recovery-phone-btn']");
        private SelenideElement recoveryByEmailButton = $("[data-test-id= 'recovery-email-btn']");
        private SelenideElement goToSupportButton = $("[data-test-id='support-contact-btn']");

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
    }

