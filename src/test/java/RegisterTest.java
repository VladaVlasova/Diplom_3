import ru.praktikum.burger.api.Endpoints;
import ru.praktikum.burger.api.TestFields;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.burger.page.objects.LoginPage;
import ru.praktikum.burger.page.objects.MainPage;
import ru.praktikum.burger.page.objects.RegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class RegisterTest {
    MainPage mainPage;
    TestFields commonFields = new TestFields();
    @Before
    public void setUp() {
        //  System.setProperty("webdriver.chrome.driver", TestFields.yandexDriver);
        mainPage = open(Endpoints.URL, MainPage.class);
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        webdriver().driver().getWebDriver().manage().window().maximize();
    }
    @Test
    @DisplayName("проверка успешной регистрации")
    public void verifyThatUserWasAutorisedByClickingOnLoginRegisterButton() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        RegisterPage registerPage = loginPage.clickOnLoginRegisterButton();
        registerPage.setRegisterFieldsAndClickRegisterButton(commonFields.name, commonFields.email, commonFields.password);
        Assert.assertTrue(loginPage.getTextloginLoginText().contains("Вход"));
    }
    @Test
    @DisplayName("проверка ошибки для некорректного пароля")
    public void verifyThatUserNotAutorisedWithInvalidPassword() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        RegisterPage registerPage = loginPage.clickOnLoginRegisterButton();
        registerPage.setRegisterFieldsAndClickRegisterButton(commonFields.name, commonFields.email, commonFields.invalidPassword);
        Assert.assertTrue(registerPage.getTextInvalidPasswordText().contains("Некорректный пароль"));
    }
    @After
    public void closeDriver() {
        webdriver().driver().getWebDriver().quit();
    }
}
