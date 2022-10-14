package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage extends BasePage {

    protected Logger log = LoggerFactory.getLogger(RegisterPage.class);

    public RegisterPage() {
        super("Register Page");
    }

    private final SelenideElement loginButton = $x("//button[@class = 'login-btn']");
    private final SelenideElement googleButton = $x("//button[@class = 'google-login']");
    private final SelenideElement facebookButton = $x("//button[@class = 'facebook-login']");
    private final SelenideElement registrationButton = $x("//button[@type = 'submit']");
    private final SelenideElement backToLogin = $x("//a[@class = 'login']");
    private final SelenideElement nameField = $x("//form//input[@type = 'text']");
    private final SelenideElement emailField = $x("//input[@type = 'email']");
    private final SelenideElement passwordField = $x("//input[@type = 'password']");
    private final SelenideElement backLink = $x("//div[@class = 'link-back']");
    private final SelenideElement errorMessage = $x("//div[@class ='error-message']");

    @Step("Create new user")
    public void createNewUser() {
        loginButton.shouldBe(Condition.visible).click();
        registrationButton.shouldBe(Condition.visible).click();
        errorMessage.shouldBe(Condition.visible).shouldBe(Condition.exactText("Name is required"));
        nameField.shouldBe(Condition.visible).sendKeys("TestName");
        registrationButton.shouldBe(Condition.visible).click();
        errorMessage.shouldBe(Condition.visible).shouldBe(Condition.exactText("Email is required!"));
        emailField.shouldBe(Condition.visible).sendKeys("email@com");
        registrationButton.shouldBe(Condition.visible).click();
        errorMessage.shouldBe(Condition.visible).shouldBe(Condition.exactText("Valid Email is required!"));
        emailField.shouldBe(Condition.visible).clear();
        emailField.shouldBe(Condition.visible).sendKeys("email@test.com");
        registrationButton.shouldBe(Condition.visible).click();
        errorMessage.shouldBe(Condition.visible).shouldBe(Condition.exactText("Password is required!"));
        passwordField.shouldBe(Condition.visible).sendKeys("1234");
        registrationButton.shouldBe(Condition.visible).click();
        errorMessage.shouldBe(Condition.visible).shouldBe(Condition.exactText("Password is too weak!"));
        passwordField.shouldBe(Condition.visible).sendKeys("Test/123");
        registrationButton.shouldBe(Condition.visible).click();
        backLink.shouldBe(Condition.visible).shouldBe(Condition.ownText(" We have sent you a Code!"));
    }
}
