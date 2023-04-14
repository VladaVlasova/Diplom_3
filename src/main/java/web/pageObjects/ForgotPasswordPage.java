package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
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
    public void setForgotPasswordEmailField(String a) {
        forgotPasswordEmailField.setValue(a);
    }
    public LoginPage clickOnForgotPasswordRecoverButton() {
        forgotPasswordRecoverButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }
    public LoginPage clickOnForgotPasswordLoginButton() {
        forgotPasswordLoginButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }
    public ForgotPasswordPage setForgotPasswordFields(String a) {
        setForgotPasswordEmailField(a);
        clickOnForgotPasswordRecoverButton();
        return page(ForgotPasswordPage.class);
    }
}
