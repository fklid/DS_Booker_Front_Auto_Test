package tests.mobile;

import core.base.MobileBaseTest;
import core.pages.mobile.MobileLoginPage;
import core.pages.mobile.MobileRecoveryPage;
import core.pages.mobile.MobileRecoveryPhonePage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileRecoveryByPhoneTest extends MobileBaseTest {
    private static MobileLoginPage mobileLoginPage;
    private static MobileRecoveryPage mobileRecoveryPage;
    private static MobileRecoveryPhonePage mobileRecoveryPhonePage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        mobileLoginPage = new MobileLoginPage();
        mobileLoginPage.acceptCookies();
    }

    @Test
    public void testRecoveryByPhone() {
        mobileLoginPage.login("random_user", "random_pass");

        for (int i=0; i<2; i++) {
            mobileLoginPage.loginByPasswordOnly("xxx");
        }

        mobileLoginPage.goToRecoveryPage();
        mobileRecoveryPage = new MobileRecoveryPage();

        mobileRecoveryPage.recoveryByPhone();
        mobileRecoveryPhonePage = new MobileRecoveryPhonePage();

        String countryCode = mobileRecoveryPhonePage.selectCountry("Австрия");
        assertEquals("+43", countryCode, "Не верный код");

        mobileRecoveryPhonePage.submitPhoneNumber();
    }
}
