package web.pageObjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.page;
public class AutorisedMainPage {
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement autorisedMainMakeOrderButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    private SelenideElement autorisedMainPersonalAreaButton;
    public String getTextAutorisedMainMakeOrderButton() {
        return autorisedMainMakeOrderButton.getText();
    }
    public AutorisedPersonalPage clickOnAutorisedMainPersonalAreaButton() {
        autorisedMainPersonalAreaButton.shouldBe(enabled).click();
        return page(AutorisedPersonalPage.class);
    }
}
