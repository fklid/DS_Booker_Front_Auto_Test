package tests.mobile;

import core.base.MobileBaseTest;
import core.pages.mobile.MobileLoginPage;
import core.pages.mobile.MobileRecoveryEmailPage;
import core.pages.mobile.MobileRecoveryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class MobileRecoveryByEmailTest  extends MobileBaseTest {
    private static MobileLoginPage mobileLoginPage;
    private static MobileRecoveryPage mobileRecoveryPage;
    private static MobileRecoveryEmailPage mobileRecoveryEmailPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobileLoginPage = new MobileLoginPage();
        mobileLoginPage.acceptCookies();
    }

    @Test
    public void testMobileRecoveryByEmail() {
        mobileLoginPage.login("invalid_username", "invalid_password");

        for (int i=0; i<2; i++) {
            mobileLoginPage.loginByPasswordOnly("0");
        }

        mobileLoginPage.goToRecoveryPage();
        mobileRecoveryPage = new MobileRecoveryPage();

        mobileRecoveryPage.recoveryByEmail();
        mobileRecoveryEmailPage = new MobileRecoveryEmailPage();

        mobileRecoveryEmailPage.returnToPrevPage();
    }
}
