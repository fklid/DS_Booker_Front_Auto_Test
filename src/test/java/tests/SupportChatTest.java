package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import core.pages.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class SupportChatTest extends BaseTest {
    private static LoginPage loginPage;
    private static RecoveryPage recoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();
    }

    @Test
    public void testSupportChat() {
        loginPage.accessRecovery();
        recoveryPage = new RecoveryPage();

        recoveryPage.openSupportChat();
        recoveryPage.closeChat();
        recoveryPage.checkChatClosed();
    }
}
