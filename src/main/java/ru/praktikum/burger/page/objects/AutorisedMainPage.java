package ru.praktikum.burger.page.objects;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
public class AutorisedMainPage {
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement autorisedMainMakeOrderButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    private SelenideElement autorisedMainPersonalAreaButton;
    public String getTextAutorisedMainMakeOrderButton() {
        return autorisedMainMakeOrderButton.getText();
    }
    @Step("клик на Личный кабинет")
    public AutorisedPersonalPage clickOnAutorisedMainPersonalAreaButton() {
        autorisedMainPersonalAreaButton.shouldBe(enabled).click();
        return Selenide.page(AutorisedPersonalPage.class);
    }
}
