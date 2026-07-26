package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {
    private SelenideElement groupHeader = $("#group-name");
    private SelenideElement groupLink  = $(".group-slug");
    private SelenideElement membersCounter  = $("#members-count");
    private SelenideElement joinButton = $(".btn-primary");
    private SelenideElement returnButton = $(".btn-secondary");

    {
        verifyPageElements();
    }

    @Step("Проверка отображения элементов страницы")
    private void verifyPageElements() {
        groupHeader.shouldBe(visible);
        groupLink .shouldBe(visible);
        membersCounter.shouldBe(visible);
        joinButton.shouldBe(visible);
        returnButton.shouldBe(visible);
    }

    @Step("Проверка названия группы")
    public String checkGroupName() {
        groupHeader.shouldBe(visible);
        String groupName = groupHeader.getText();
        return groupName;
    }

    @Step("Возврат на первую страницу")
    public void goBack() {
        returnButton.shouldBe(visible).click();
    }
}