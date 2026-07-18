package core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryPhonePage extends BasePage {
    private SelenideElement phoneEntryField = $("[data-test-id='phone-input']");
    private SelenideElement countrySelectDropdown = $("[data-test-id='country-select-btn']");
    private SelenideElement getCodeButton = $("[data-test-id='phone-submit-btn']");

    {
        verifyPageElements();
    }

    @Step("Проверка элементов страницы")
    private void verifyPageElements() {
        phoneEntryField.shouldBe(visible);
        countrySelectDropdown.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Ввод номера")
    public void setPhoneNumber(String phone) {
        phoneEntryField.setValue(phone);
    }

    @Step("Выбор страны из списка")
    public String selectCountry(String countryName) {
        countrySelectDropdown.click();
        SelenideElement countryItem = $x(String.format("//div[@class='custom-select-option'][.//span[text()='%s']]", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.attr("data-value");
        countryItem.click();
        return countryCode;
    };

    @Step("Подтверждение номера")
    public void submitPhoneNumber() {
        getCodeButton.click();
    }


}
