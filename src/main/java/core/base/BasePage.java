package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[data-test-id='logo-icon']");
    protected SelenideElement searchField = $("[id='search-input']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");



    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }


    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }


    public void openVKServices() {
        vkServices.shouldBe(visible).click();
    }

}