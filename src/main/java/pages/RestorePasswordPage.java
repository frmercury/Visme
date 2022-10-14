package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RestorePasswordPage  extends BasePage{

    protected Logger log = LoggerFactory.getLogger(RestorePasswordPage.class);

    public RestorePasswordPage() {
        super("Restore forgotten password");
    }

    private final SelenideElement emailField = $x("//input[@type = 'email']");
    private final SelenideElement resetButton = $x("//button[@type= 'submit']");
    private final SelenideElement signUpButton = $x("//a[@class= 'register']");
    private final SelenideElement backToLogin = $x("//a[@class = 'login']");
    private final SelenideElement confirmPopup = $x("//div[@role='alert']");

    public void sentResetEmail() {

        emailField.shouldBe(Condition.visible).sendKeys("test@valid.com");
        resetButton.shouldBe(Condition.visible).click();
        confirmPopup.shouldBe(Condition.visible);
        webdriver().shouldHave(url("https://dashboard.visme.co/v2/login"));
        log.info("Login page is opened");
    }
}
