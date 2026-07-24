package tests.web;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class QrScreenTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void enterByQr() {
        loginPage.openQrScreen();
        loginPage.checkQrScreen();
    }

}
