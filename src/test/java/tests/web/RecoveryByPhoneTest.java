package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryPage;
import core.pages.web.RecoveryPhonePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryByPhoneTest extends BaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recoveryPage;
    private static RecoveryPhonePage recoveryPhonePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }
    @Test
    public void testRecoveryByPhone() {
        loginPage.login("random_user", "random_pass");

        for (int i=0; i<2; i++) {
            loginPage.loginPasswordOnly("q");
        }

        loginPage.goToRecoveryPage();
        recoveryPage = new RecoveryPage();

        recoveryPage.goToRecoveryByPhone();
        recoveryPhonePage = new RecoveryPhonePage();

        String countryCode = recoveryPhonePage.selectCountry("Аргентина");
        assertEquals("+54", countryCode, "Не верный код");

        recoveryPhonePage.submitPhoneNumber();
    }
}
