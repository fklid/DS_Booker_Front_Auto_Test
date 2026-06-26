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

    private SelenideElement emptyPassword = $x("//span[text()='Введите пароль']");
    private SelenideElement emptyUsername = $x("//span[text()='Введите логин']");


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
    public boolean isErrorMessage() {
        return errorMessage.shouldBe(visible).exists();
    }


    @Step("Получить текст ошибки об отсутствии имени пользователя")
    public String getEmptyUsernameMessage() {
        return emptyUsername.shouldBe(visible).getText();
    }
    @Step("Проверка входа только под именем пользователя")
    public void loginUsernameOnly(String username){
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверка входа только с паролем")
    public void loginPasswordOnly(String password){
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверка сообщение об ошибке с пропущенным паролем")
    public boolean isEmptyPasswordMessage() {
        return emptyPassword.shouldBe(visible).exists();
    }

    @Step("Проверка ввода только пароля")
    public boolean isEmptyUsernameMessage() {
        return emptyUsername.shouldBe(visible).exists();
    }

    @Step("Получить сообщение об ошибки с пропущенным паролем")
    public String getEmptyPasswordMessage() {
        return emptyPassword.shouldBe(visible).getText();
    }

    @Step("Получить сообщение об ошибке отсутствия имени пользователя")
    public String getEmptyUsernameErrorMessage() {
        return emptyUsername.shouldBe(visible).getText();
    }

}