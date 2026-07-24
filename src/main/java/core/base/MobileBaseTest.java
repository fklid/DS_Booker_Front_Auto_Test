package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobileBaseTest extends AbstractBaseTest{
    @Override
    protected void configure() {
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation",
                Map.of("deviceName", "iPhone 12 Pro"));

        Configuration.browserCapabilities = options;
    }
}
