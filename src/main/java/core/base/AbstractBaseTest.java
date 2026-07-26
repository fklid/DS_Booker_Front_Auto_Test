package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class AbstractBaseTest {
    protected static String baseUrl;

    @BeforeEach
    protected void setUp() {
        baseUrl = determineBaseUrl();
        configure();
    }

    protected abstract void configure();

    private static String determineBaseUrl() {
        String environment = System.getProperty("env", "test");
        String configFileName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new IllegalStateException("Could not locate config file: " + configFileName);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Config file was not found: " + configFileName, e);
        }
        return properties.getProperty("baseUrl");
    };

    @AfterEach
    protected void tearDown() {
        closeWebDriver();
    }
}
