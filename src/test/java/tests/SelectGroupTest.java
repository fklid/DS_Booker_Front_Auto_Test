package tests;

import core.base.BaseTest;
import core.pages.GroupPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectGroupTest extends BaseTest {

    // УБРАЛИ static!
    private LoginPage loginPage;
    private GroupPage groupPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
        loginPage.acceptCookies();

    }

    @Test
    public void testOpenGroupPage() {
        String testGroupName = "Тестировщик QA";

        loginPage.getSearchResults("Тестировщик QA");
        loginPage.selectResultFromList(testGroupName);

        groupPage = new GroupPage();

        assertEquals(testGroupName, groupPage.checkGroupName(),
                "Название группы не соответствует запрошенному");

        groupPage.goBack();
    }
}