package ru.praktikum.burger.page.objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class RegisterPage {
    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']/following-sibling::input")  // поле имя
    private SelenideElement registerNameField;
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']/following-sibling::input") // поле email
    private SelenideElement registerEmailField;
    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']/following-sibling::input") // поле пароль
    private SelenideElement registerPasswordField;
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']") // кнопка Зарегистрироваться
    private SelenideElement registerRegisterButton;
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']") // кнопка Войти
    private SelenideElement registerLoginButton;
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")  // текст Некорректный пароль
    private SelenideElement invalidPasswordText;
    @Step("ввод имени")
    public void setRegisterNameField(String a) {
        registerNameField.setValue(a);
    }
    @Step("ввод email")
    public void setRegisterEmailField(String a) {
        registerEmailField.setValue(a);
    }
    @Step("ввод пароля")
    public void setRegisterPasswordField(String a) {
        registerPasswordField.setValue(a);
    }
    @Step("клик по Зарегистрироваться")
    public void clickOnRegisterRegisterButton() {
        registerRegisterButton.scrollTo();
        registerRegisterButton.shouldBe(enabled).click();
    }
    @Step("клик по Войти")
    public LoginPage clickOnRegisterLoginButton() {
        registerLoginButton.shouldBe(enabled).click();
        return Selenide.page(LoginPage.class);
    }
    @Step("Заполнение формы регистрации и клик по Зарегистрироваться")
    public LoginPage setRegisterFieldsAndClickRegisterButton(String a, String b, String c) {
        setRegisterNameField(a);
        setRegisterEmailField(b);
        setRegisterPasswordField(c);
        clickOnRegisterRegisterButton();
        return Selenide.page(LoginPage.class);
    }
    public String getTextInvalidPasswordText() {
        return invalidPasswordText.getText();
    }
}
