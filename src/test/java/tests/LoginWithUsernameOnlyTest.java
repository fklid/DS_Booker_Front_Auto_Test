package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithUsernameOnlyTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        //loginPage.acceptCookies();
    }

    @Test
    public void loginWithUsernameOnlyTest() {
        loginPage.loginUsernameOnly("user01test");

        assertTrue(loginPage.isEmptyPasswordMessage());

        String expectedErrorMessage = "Введите пароль";
        String actualErrorMessage = loginPage.getEmptyPasswordMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Не верный текст ошибки");
    }
}
