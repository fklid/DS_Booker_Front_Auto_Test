package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithPasswordOnlyTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        //loginPage.acceptCookies();
    }

    @Test
    public void testLoginWithPasswordOnly() {
        loginPage.loginPasswordOnly("test PASSWORD");

        assertTrue(loginPage.isEmptyUsernameMessage());

        String expectedErrorMessage = "Введите логин";
        String actualErrorMessage = loginPage.getEmptyUsernameErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Не верный текст ошибки");
    }
}
