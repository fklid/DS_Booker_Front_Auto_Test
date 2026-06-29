package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected SelenideElement headerLogo = $("[data-test-id='logo-icon']");
    protected SelenideElement searchField = $("[id='search-input']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement cookiesAccept = $("[data-test-id='cookie-accept-btn']");
    protected SelenideElement acceptPrivacyButton = $("cmptxt_btn_yes");




    @Step ("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }


    @Step ("Выполняем запрос по сайту {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }


    @Step("Открываем ВК сервисы")
    public void openVKServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Принимаем  cookies сайта")
    public void acceptCookies() {
        cookiesAccept.shouldBe(visible).click();
    }

    @Step("Принимаем политику конф. сайта")
    public void acceptPrivacyButton() {
        acceptPrivacyButton .shouldBe(visible).click();
    }

}