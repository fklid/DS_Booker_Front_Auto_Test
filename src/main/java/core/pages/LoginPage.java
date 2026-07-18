package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selectors.byText;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[data-test-id='login-phone-email']");
    private SelenideElement passwordField = $("[data-test-id='login-password']");
    private SelenideElement loginButton = $("[data-test-id='login-submit-btn']");
    private SelenideElement accessRecovery =   $("[data-test-id='forgot-password-link']");
    private SelenideElement registerButton = $x("//div[@id='hero-buttons']//button[@id='hero-register-btn']");
    private SelenideElement loginByQr = $("[data-test-id='tab-qr']");
    private SelenideElement qrPlaceholder = $("[data-test-id='qr-placeholder']");
    private SelenideElement qrCode = qrPlaceholder.$("svg");


    // Локатор элемента с сообщением об ошибке
    private SelenideElement errorMessage = $x("//form[@id='loginForm']//div[contains(text(), 'Пользователь с таким телефоном, почтой или логином не найден.')]");

    private SelenideElement emptyPassword = $x("//form[@id='loginForm']//div[contains(text(), 'Введите телефон, email или логин и пароль.')]");
    private SelenideElement emptyUsername =  $x("//form[@id='loginForm']//div[contains(text(), 'Введите телефон, email или логин и пароль.')]");
    private SelenideElement recoveryButton = $("[data-test-id='lockout-recover-btn']");

    // Страница поиска
    private SelenideElement searchInput = $("[data-test-id='search-input']");
    private SelenideElement searchResultsList = $("[data-test-id='search-results']");



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



    @Step("Переходим на страницу восстановления доступа")
    public void accessRecovery() {
        accessRecovery.shouldBe(visible).click();
    }

    @Step("Go to recovery page by button")
    public void goToRecoveryPage() {
        recoveryButton.shouldBe(visible).click();
    }

    @Step("Открыть экран QR")
    public LoginPage openQrScreen() {
        loginByQr.shouldBe(visible).click();
        return this;
    }

    @Step("Проверка отображения элементов экрана QR")
    public void checkQrScreen() {
        qrPlaceholder.shouldBe(visible);
        loginByQr.shouldHave(cssClass("active"));
        qrCode.shouldBe(visible);
    }

    @Step("Ввод запроса '{query}' в поле поиска и ожидание результатов")
    public void getSearchResults(String query) {
        searchInput.shouldBe(visible).click();
        searchInput.setValue(query);
        searchResultsList.shouldBe(visible);
    }

    @Step("Выбор результата '{groupName}' из списка поиска")
    public void selectResultFromList(String groupName) {
        $(byText(groupName)).shouldBe(visible).scrollTo().click();
    }


}