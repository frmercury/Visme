package tests.ui;

import entities.user.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

@Test
public class LoginTest extends BaseTest {

    private User user;

    @BeforeClass(alwaysRun = true,
            description = "Test entity creation")
    public synchronized void setTestData() {
        this.user = new User();
    }

    public void authTest() throws InterruptedException {
        new LoginPage()
                .login(this.user)
                .checkLogin()
                .logOut();
    }
    public void signUpTest() {
        new LoginPage()
                .doSignUp()
                .createNewUser();
    }
    public void resetPassword() {
        new LoginPage()
                .restorePassword()
                .sentResetEmail();
    }
    public void checkPopUpIsDisplayable() {
        new LoginPage()
                .openHelpPopup()
                .closeHelpPopup();
    }

    @AfterClass(alwaysRun = true,
            description = "Test entity erasing")
    public void cleanTestData() {
        this.user = null;
    }
}