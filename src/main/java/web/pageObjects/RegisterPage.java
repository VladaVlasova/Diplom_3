package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;

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
    public void setRegisterNameField(String a) {
        registerNameField.setValue(a);
    }
    public void setRegisterEmailField(String a) {
        registerEmailField.setValue(a);
    }
    public void setRegisterPasswordField(String a) {
        registerPasswordField.setValue(a);
    }
    public void clickOnRegisterRegisterButton() {
        registerRegisterButton.scrollTo();
        registerRegisterButton.shouldBe(enabled).click();
    }
    public LoginPage clickOnRegisterLoginButton() {
        registerLoginButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }
    public LoginPage setRegisterFieldsAndClickRegisterButton(String a, String b, String c) {
        setRegisterNameField(a);
        setRegisterEmailField(b);
        setRegisterPasswordField(c);
        clickOnRegisterRegisterButton();
        return page(LoginPage.class);
    }
    public String getTextInvalidPasswordText() {
        return invalidPasswordText.getText();
    }
}
