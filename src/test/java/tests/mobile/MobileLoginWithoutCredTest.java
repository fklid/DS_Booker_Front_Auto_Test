package tests.mobile;

import core.base.MobileBaseTest;
import core.pages.mobile.MobileLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileLoginWithoutCredTest extends MobileBaseTest {
    private static MobileLoginPage mobileLoginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobileLoginPage = new MobileLoginPage();
        mobileLoginPage.acceptCookies();
    }

    @Test
    public void testMobileLoginWithoutCredentials() {
        mobileLoginPage.loginWithNoCredentials();

        assertTrue(mobileLoginPage.isMissingCredentialsMessagePresent(), "Сообщение об ошибке не отображается");

        String expectedErrorMessage = "Введите телефон, email или логин и пароль.";
        String actualErrorMessage = mobileLoginPage.getMissingCredentialsErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
