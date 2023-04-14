package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
public class MainPage {
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement mainLogoButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    private SelenideElement mainPersonalAreaButton;
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement mainMakeBurgerText;
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement mainLoginButton;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo")
    private SelenideElement mainConstructorButton;
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement mainBunsButton;
    @FindBy(how = How.XPATH, using = "//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement mainBunFluorescentText;
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement mainSaucesButton;
    @FindBy(how = How.XPATH, using = "//p[text()='Соус Spicy-X']")
    private SelenideElement mainSauceSpicyxText;
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement mainFillingsButton;
    @FindBy(how = How.XPATH, using = "//p[text()='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement mainFillingProtostomiaText;
    public void clickOnMainLogoButton() {
        mainLogoButton.shouldBe(enabled).click();
    }
    public LoginPage clickOnMainPersonalAreaButton() {
        mainPersonalAreaButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }
    public LoginPage clickOnMainLoginButton() {
        mainLoginButton.shouldBe(enabled).click();
        return page(LoginPage.class);
    }
    public void clickOnMainConstructorButton() {
        mainConstructorButton.shouldBe(enabled).click();
    }
    public void clickOnMainBunsButton() {
        mainBunsButton.shouldBe(enabled).click();
    }
    public void clickOnMainSaucesButton() {
        mainSaucesButton.shouldBe(enabled).click();
    }
    public void clickOnMainFillingsButton() {
        mainFillingsButton.shouldBe(enabled).click();
    }
    public String getTextMainMakeBurgerText() {
        return mainMakeBurgerText.getText();
    }
    public String getTextMainSauceSpicyxText() {
        return mainSauceSpicyxText.getText();
    }
    public String getTextMainFillingProtostomiaText() {
        return mainFillingProtostomiaText.getText();
    }
    public String getTextMainBunFluorescentText() {
        return mainBunFluorescentText.getText();
    }
}
