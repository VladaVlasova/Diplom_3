package ru.praktikum.burger.page.objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;


public class AutorisedPersonalPage {
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement autorisedPersonalAreaExitButton;
    @Step("клик на Выход")
    public LoginPage clickOnAutorisedPersonalAreaExitButton() {
        autorisedPersonalAreaExitButton.shouldBe(enabled).click();
        return Selenide.page(LoginPage.class);
    }
}
