package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[data-test-id='login-input']");
    private SelenideElement passwordField = $("[data-test-id='password-input']");
    private SelenideElement loginButton = $("[data-test-id='enter-action']");
    private SelenideElement accessRecovery = $x("//button class [text()='Не получается войти?']");
    private SelenideElement registerButton = $x("//a[text()='Зарегистрироваться']");

    // Локатор элемента с сообщением об ошибке
    private SelenideElement errorMessage = $x("//span[text()='Неправильно указан логин и/или пароль']");

    private SelenideElement emptyCredentials = $x("//span[text()='Введите пароль']");
    private SelenideElement invalidCredentials = $x("//form[@id='loginForm']//div[contains(text(), 'Пользователь с таким телефоном, почтой или логином не найден.')]");


    {
        verifyPageElements();
    }

    @Step("Проверки видимости всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        // accessRecovery.shouldBe(visible);
       // registerButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверка при входе без учетных данных, появляется сообщение об ошибке входа в систему")
    public boolean isErrorMessagePresent() {
        return emptyCredentials.shouldBe(visible).exists();
    }

    @Step("Проверка сообщение об ошибке 'отсутствует имя пользователя'")
    public boolean IsinvalidUsernameMessagePresent() {
        return invalidCredentials.shouldBe(visible).exists();
    }

    @Step("Получить текст ошибки об отсутствии имени пользователя")
    public String getEmptyUsernameErrorMessage() {
        return emptyCredentials.shouldBe(visible).getText();
    }
    @Step("Проверка входа  только под именем пользователя")
    public void loginUsernameOnly(String username){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Check that missing password error message appears")
    public boolean isEmptyPasswordMessage() {
        return emptyCredentials.shouldBe(visible).exists();
    }

    @Step("Obtain missing password error text")
    public String getMissingPasswordErrorMessage() {
        return emptyCredentials.shouldBe(visible).getText();
    }



}