package tests.mobile;

import core.base.MobileBaseTest;
import core.pages.mobile.MobileLoginPage;
import core.pages.mobile.MobileRecoveryPage;
import core.pages.web.RecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class MobileSupportChatTest extends MobileBaseTest {
    private static MobileLoginPage mobileLoginPage;
    private static MobileRecoveryPage mobileRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobileLoginPage = new MobileLoginPage();
        mobileLoginPage.acceptCookies();
    }

    @Test
    public void testMobileSupportChat() {
        mobileLoginPage.openPasswordRecoveryPage();
        mobileRecoveryPage = new MobileRecoveryPage();

        mobileRecoveryPage.referToSupport();
        mobileRecoveryPage.closeChat();
        mobileRecoveryPage.checkChatClosed();

        mobileRecoveryPage.returnToLogin();
    }
}
