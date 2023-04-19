package ru.praktikum.burger.page.objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement loginLoginText;
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement loginEmailField;
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement loginPasswordField;
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginLoginButton;
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement loginRegisterButton;
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement loginForgotPasswordButton;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement loginLogoButton;
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement loginConstructorButton;
    @Step("ввод email")
    public void setLoginEmailField(String a) {
        loginEmailField.setValue(a);
    }
    @Step("ввод пароля")
    public void setLoginPasswordField(String a) {
        loginPasswordField.setValue(a);
    }
    @Step("клик по Войти")
    public void clickOnLoginLoginButton() {
        loginLoginButton.shouldBe(enabled).click();
    }
    @Step("клик по Зарегистрироваться")
    public RegisterPage clickOnLoginRegisterButton() {
        loginRegisterButton.shouldBe(enabled).click();
        return page(RegisterPage.class);
    }
    @Step("клик по Восстановить пароль")
    public ForgotPasswordPage clickOnLoginForgotPasswordButton() {
        loginForgotPasswordButton.shouldBe(enabled).click();
        return page(ForgotPasswordPage.class);
    }
    @Step("Заполнение полей авторизации и клик по Войти")
    public AutorisedMainPage setLoginFields(String a, String b) {
        setLoginEmailField(a);
        setLoginPasswordField(b);
        clickOnLoginLoginButton();
        return page(AutorisedMainPage.class);
    }
    public String getTextLoginLoginButton() {
        return loginLoginButton.getText();
    }
    public String getTextloginLoginText() {
        return loginLoginText.getText();
    }
    @Step("Клик на логотип")
    public MainPage clickOnLogoButton() {
        loginLogoButton.shouldBe(enabled).click();
        return page(MainPage.class);
    }
    @Step("Клик по кнопке Конструктор")
    public MainPage clickOnLoginConstructorButton() {
        loginConstructorButton.shouldBe(enabled).click();
        return page(MainPage.class);
    }
}
