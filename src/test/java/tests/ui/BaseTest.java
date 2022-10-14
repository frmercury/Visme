package tests.ui;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Loader.loadProperty;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;

public abstract class BaseTest {

    protected Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true, description = "Driver props init")

    public void initProps() {

        DesiredCapabilities caps = new DesiredCapabilities();

        //browser settings
        browser = getProperty("browser");
        baseUrl = loadProperty("app.url");
        timeout = parseInt(loadProperty("timeout.global"));

        caps.setCapability("browser", getProperty("browser").toLowerCase(Locale.ROOT));
        browserCapabilities = caps;
    }

    @BeforeMethod
    protected void initWebBrowser() {
        open("");
    }

    @AfterMethod(alwaysRun = true, description = "End browser session")
    public void closeWebBrowser() {
        log.info("Browser is closed");
    }
}
