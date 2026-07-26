package core.pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import core.pages.web.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class MobileLoginPage extends BasePage {
    private SelenideElement usernameField = $("[data-test-id='login-phone-email']");
    private SelenideElement passwordField = $("[data-test-id='login-password']");
    private SelenideElement loginButton = $("[data-test-id='login-submit-btn']");
    private SelenideElement loginByQr = $("[data-test-id='tab-qr']");
    private SelenideElement accessRecovery = $("[data-test-id='forgot-password-link']");
    private SelenideElement registerButton = $("[data-test-id='hero-register-btn']");

    private SelenideElement missingCredentials = $x("//form[@id='loginForm']//div[contains(text(), 'Введите телефон, email или логин и пароль.')]");
    private SelenideElement invalidCredentials = $x("//form[@id='loginForm']//div[contains(text(), 'Пользователь с таким телефоном, почтой или логином не найден.')]");

    private SelenideElement recoveryButton = $("[data-test-id='lockout-recover-btn']");

    private SelenideElement qrPlaceholder = $("[data-test-id='qr-placeholder']");
    private SelenideElement qrCode = qrPlaceholder.$("svg");

    {
        verifyPageElements();
    }

    @Step("Проверка отображения элементов")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        loginByQr.shouldBe(visible);
        accessRecovery.shouldBe(visible);
        registerButton.shouldBe(visible);
    }

    @Step("Проверка отображения ошибки при незаполнении данны ")
    public boolean isMissingCredentialsMessagePresent() {
        return missingCredentials.shouldBe(visible).exists();
    }

    @Step("Проверка отображения ошибки о незаполненных данных")
    public String getMissingCredentialsErrorMessage() {
        return missingCredentials.shouldBe(visible).getText();
    }

    @Step("Проверка отображения ошибки о неправильном вводе данных")
    public String getInvalidCredentialsErrorMessage() {
        return invalidCredentials.shouldBe(visible).getText();
    }

    @Step("Авторизация без ввода учетных данных")
    public void loginWithNoCredentials() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверка входа только под именем пользователя")
    public void loginByUsernameOnly(String username){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверка входа только с паролем")
    public void loginByPasswordOnly(String password){
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Переход на страницу восстановления по забытому паролю")
    public void openPasswordRecoveryPage() {
        accessRecovery.shouldBe(visible).click();
    }

    @Step("Открытие страницы регистрации")
    public void openRegistrationPage() {
        registerButton.shouldBe(visible).click();
    }


    @Step("Открыть экран QR")
    public void assessQrTab() {
        qrPlaceholder.shouldBe(visible);
        loginByQr.shouldHave(cssClass("active"));
        qrCode.shouldBe(visible);
    }

    @Step("Переход на страницу восстановления по кнопке")
    public void goToRecoveryPage() {
        recoveryButton.shouldBe(visible).click();
    }

    @Step("Нажатие кнопку входа в систему")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }
}
