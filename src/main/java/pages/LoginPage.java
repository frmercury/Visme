package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import entities.user.User;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selectors.shadowCss;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    protected Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage() {
        super("Login page");
    }

    private final SelenideElement loginField = $x("//input[@type = 'email']");
    private final SelenideElement passwordField = $x("//input[@type = 'password']");
    private final SelenideElement signUpButton = $x("//a[@class= 'register']");
    private final SelenideElement loginButton = $x("//button[@type= 'submit']");
    private final SelenideElement errorMessage = $x("//div[@class ='error-message']");
    private final SelenideElement googleButton = $x("//button[@class = 'google-login']");
    private final SelenideElement facebookButton = $x("//button[@class = 'facebook-login']");
    private final SelenideElement restorePasswordButton = $x("//a[@class = 'restore right']");
//    private final SelenideElement helpPopup = $x("//visme-help-popup");
    private final SelenideElement helpPopup = $(shadowCss("img", "visme-help-popup"));
    private final SelenideElement helpPopupContainer = $(shadowCss("div.summary", "visme-help-popup"));

    @Step("Login to the app")
    public MainPage login(User user) {
        loginField.shouldBe(Condition.visible).sendKeys(user.getLogin());
        passwordField.shouldBe(Condition.visible).sendKeys(user.getPassword());
        loginButton.shouldBe(Condition.visible).click();
        return new MainPage();
    }

    @Step("SignUp")
    public RegisterPage doSignUp() {
        signUpButton.shouldBe(Condition.visible).click();
        return new RegisterPage();
    }

    @Step("Restore client password")
    public RestorePasswordPage restorePassword() {
        restorePasswordButton.shouldBe(Condition.visible).click();
        return new RestorePasswordPage();
    }

    @Step("Open help popup")
    public LoginPage openHelpPopup() {
        helpPopup.shouldBe(Condition.visible).shouldBe(Condition.attribute("class", "open")).click();
        helpPopup.shouldBe(Condition.visible).shouldBe(Condition.attribute("class", "close"));
        helpPopupContainer.shouldBe(Condition.visible);
        return this;
    }
    @Step("Close help popup")
    public LoginPage closeHelpPopup() {
        helpPopup.shouldBe(Condition.visible).shouldBe(Condition.attribute("class", "close")).click();
        helpPopup.shouldBe(Condition.visible).shouldBe(Condition.attribute("class", "open"));
        helpPopupContainer.shouldNotBe(Condition.visible);
        return this;
    }
}
