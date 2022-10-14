package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {

    protected Logger log;

    public BasePage(String title) {
        this.log = LogManager.getLogger(title);
        log.debug("Page is open");
    }
}
