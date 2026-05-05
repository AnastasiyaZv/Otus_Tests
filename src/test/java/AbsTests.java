import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.otus.factory.BrowserMode;
import ru.otus.factory.WebDriverFactory;
import ru.otus.pages.MainPage;

public abstract class AbsTests {

    protected WebDriver driver;
    protected MainPage mainPage;

    public AbsTests(BrowserMode browserMode) {
        this.driver = new WebDriverFactory().getDriver(browserMode);
    }

    @BeforeEach
    public void webDriverStart() {
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
