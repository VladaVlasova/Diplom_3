package ru.praktikum.burger.page.objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    @FindBy(how = How.XPATH, using = "//div[@class='input__container' and contains(text(),'Email')]")
    private SelenideElement forgotPasswordEmailField;
    @FindBy(how = How.XPATH, using = "//button[text()='Восстановить']")
    private SelenideElement forgotPasswordRecoverButton;
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement forgotPasswordLoginButton;
    @Step("ввод имени в поле forgotPasswordEmailField")
    public void setForgotPasswordEmailField(String a) {
        forgotPasswordEmailField.setValue(a);
    }
    @Step("клик по Восстановить")
    public LoginPage clickOnForgotPasswordRecoverButton() {
        forgotPasswordRecoverButton.shouldBe(enabled).click();
        return Selenide.page(LoginPage.class);
    }
    @Step("клик по Войти")
    public LoginPage clickOnForgotPasswordLoginButton() {
        forgotPasswordLoginButton.shouldBe(enabled).click();
        return Selenide.page(LoginPage.class);
    }
    @Step("заполнение формы восстановления и клик по Восстановить")
    public ForgotPasswordPage setForgotPasswordFields(String a) {
        setForgotPasswordEmailField(a);
        clickOnForgotPasswordRecoverButton();
        return page(ForgotPasswordPage.class);
    }
}
