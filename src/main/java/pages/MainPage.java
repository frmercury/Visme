package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.user.User;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.reporters.jq.Main;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static java.lang.System.getProperty;

public class MainPage extends BasePage {

    protected Logger log = LoggerFactory.getLogger(MainPage.class);

    public MainPage() {
        super("Main Page");
    }

    private final SelenideElement userLogin = $x("//span[@class = 'email']");
    private final SelenideElement logOutButton = $x("//div[@role = 'tooltip']//a[@href = '/v2/logout']");

    public MainPage checkLogin() {
        userLogin.shouldBe(Condition.visible).shouldBe(Condition.exactOwnText(getProperty("user.login")));
        return this;
    }

    @Step("Logout")
    public void logOut() {
        userLogin.shouldBe(Condition.visible).click();
        logOutButton.shouldBe(Condition.visible).click();
        webdriver().shouldHave(url("https://dashboard.visme.co/v2/login"));
        log.info("Login page is opened");
    }
}