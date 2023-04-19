import ru.praktikum.burger.api.Endpoints;
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
import ru.praktikum.burger.page.objects.AutorisedMainPage;
import ru.praktikum.burger.page.objects.AutorisedPersonalPage;
import ru.praktikum.burger.page.objects.LoginPage;
import ru.praktikum.burger.page.objects.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class MainTest {
    RegisterUser registerUser = new RegisterUser();
    MainPage mainPage;
    TestFields commonFields = new TestFields();
    DeleteUser deleteUser = new DeleteUser();
    @Before
    public void setUp() {
        //  System.setProperty("webdriver.chrome.driver", TestFields.yandexDriver);
        mainPage = open(Endpoints.URL, MainPage.class);
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        webdriver().driver().getWebDriver().manage().window().maximize();
    }
    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет».")
    public void verifyClickingOnMainPersonalAreaButton() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        Assert.assertTrue(loginPage.getTextLoginLoginButton().contains("Войти"));
    }
    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор» в Конструктор из Личного кабинета")
    public void verifyClickingOnLoginConstructorButtonFromPersonalArea() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        MainPage mainPage1 = loginPage.clickOnLoginConstructorButton();
        Assert.assertTrue(mainPage1.getTextMainMakeBurgerText().contains("Соберите бургер"));
    }
    @Test
    @DisplayName("Проверка перехода по клику на Логотип в Конструктор из Личного кабинета")
    public void verifyClickingOnLogoButtonFromPersonalArea() throws InterruptedException {
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        MainPage mainPage1 = loginPage.clickOnLogoButton();
        Assert.assertTrue(mainPage1.getTextMainMakeBurgerText().contains("Соберите бургер"));
    }
    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    public void verifyThatUserWasAutorisedByClickingOnPersonalAreaButton() throws InterruptedException {
        registerUser.registerUser(commonFields.email, commonFields.password, commonFields.name);
        LoginPage loginPage = mainPage.clickOnMainPersonalAreaButton();
        AutorisedMainPage autorisedMainPage1 = loginPage.setLoginFields(commonFields.email, commonFields.password);
        AutorisedPersonalPage autorisedPersonalAreaPage = autorisedMainPage1.clickOnAutorisedMainPersonalAreaButton();
        LoginPage loginPage1 = autorisedPersonalAreaPage.clickOnAutorisedPersonalAreaExitButton();
        Assert.assertTrue(loginPage1.getTextloginLoginText().contains("Вход"));
        TestFields.accessTokenAfterRegister = TestFields.response.path("accessToken");
        deleteUser.deleteUser();
    }
    @Test
    @DisplayName("Клик на раздел 'Соусы' открывает список соусов")
    public void verifyThatClickOnMainSaucesButtonOpenListOfCouces() throws InterruptedException {
        mainPage.clickOnMainSaucesButton();
        Assert.assertTrue(mainPage.getTextMainSauceSpicyxText().contains("Соус Spicy-X"));
    }
    @Test
    @DisplayName("Клик на раздел 'Начинки' открывает список начинок")
    public void verifyThatСlickOnMainFillingsButtonOpenListOfFillings() throws InterruptedException {
        mainPage.clickOnMainFillingsButton();
        Assert.assertTrue(mainPage.getTextMainFillingProtostomiaText().contains("Мясо бессмертных моллюсков Protostomia"));
    }
    @Test
    @DisplayName("Клик на раздел 'Булки' открывает список булок")
    public void verifyThatClickOnMainBunsButtonOpenListOfBuns() throws InterruptedException {
        mainPage.clickOnMainFillingsButton();
        mainPage.clickOnMainBunsButton();
        Assert.assertTrue(mainPage.getTextMainBunFluorescentText().contains("Флюоресцентная булка R2-D3"));
    }
    @After
    public void closeDriver() {
        webdriver().driver().getWebDriver().quit();
    }
}
