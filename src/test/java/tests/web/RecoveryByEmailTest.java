package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryEmailPage;
import core.pages.web.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryByEmailTest extends BaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void testRecoveryByEmail() {

            loginPage.login("random_user", "random_pass");

            for (int i=0; i<2; i++) {
                loginPage.loginPasswordOnly("q");
            }

        loginPage.goToRecoveryPage();
        recoveryPage = new RecoveryPage();

        recoveryPage.goToRecoveryByEmail();
        new RecoveryEmailPage();
    }
}
