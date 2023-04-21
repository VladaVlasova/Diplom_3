import ru.praktikum.burger.api.TestFields;
import ru.praktikum.burger.api.DeleteUser;
import ru.praktikum.burger.api.RegisterUser;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.burger.page.objects.*;

import static ru.praktikum.burger.api.Endpoints.URL;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class LoginTest {
    MainPage mainPage;
    RegisterUser registerUser = new RegisterUser();
    TestFields testFields = new TestFields();
    DeleteUser deleteUser = new DeleteUser();
    @Before
    public void setUp() {
      //  System.setProperty("webdriver.chrome.driver", TestFields.yandexDriver);
        mainPage = open(URL, MainPage.class);
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
       webdriver().driver().getWebDriver().manage().window().maximize();
    }
    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void verifyThatUserWasAutorisedByClickingOnLoginButton() throws InterruptedException {
        registerUser.registerUser(testFields.email, testFields.password, testFields.name);
        LoginPage loginPage = mainPage.clickOnMainLoginButton();
        AutorisedMainPage autorisedMainPage1 = loginPage.setLoginFields(testFields.email, testFields.password);
        Assert.assertTrue(autorisedMainPage1.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void verifyThatUserWasAutorisedByClickingOnPersonalAreaButton() throws InterruptedException {
        registerUser.registerUser(testFields.email, testFields.password, testFields.name);
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        AutorisedMainPage autorisedMainPage = loginPage.setLoginFields(testFields.email, testFields.password);
        Assert.assertTrue(autorisedMainPage.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        TestFields.accessTokenAfterRegister = TestFields.response.path("accessToken");
    }
    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void verifyThatUserWasAutorisedByClickingOnLoginRegisterButton() throws InterruptedException {
        registerUser.registerUser(testFields.email, testFields.password, testFields.name);
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        RegisterPage registerPage = loginPage.clickOnLoginRegisterButton();
        LoginPage loginPage1 = registerPage.clickOnRegisterLoginButton();
        AutorisedMainPage autorisedMainPage1 = loginPage1.setLoginFields(testFields.email, testFields.password);
        Assert.assertTrue(autorisedMainPage1.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        TestFields.accessTokenAfterRegister = TestFields.response.path("accessToken");
    }
    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void verifyThatUserWasAutorisedByClickingOnLoginForgotPasswordButton() throws InterruptedException {
        registerUser.registerUser(testFields.email, testFields.password, testFields.name);
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickOnLoginForgotPasswordButton();
        LoginPage loginPage1 = forgotPasswordPage.clickOnForgotPasswordLoginButton();
        AutorisedMainPage autorisedMainPage1 = loginPage1.setLoginFields(testFields.email, testFields.password);
        Assert.assertTrue(autorisedMainPage1.getTextAutorisedMainMakeOrderButton().contains("Оформить заказ"));
        TestFields.accessTokenAfterRegister = TestFields.response.path("accessToken");
    }
    @After
    public void deleteUSer() {
        if (TestFields.accessTokenAfterRegister != null) {
            deleteUser.deleteUser();
        }
    }
    @After
    public void closeDriver() {
        webdriver().driver().getWebDriver().quit();
    }
}
