import factory.BrowserMode;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Открыть Chrome в режиме киоска
//Перейти на ресурс
//Нажать на «Открыть модальное окно»
//Проверить, что открылось модальное окно
public class OpenModalWindow {

    private WebDriver driver;
    private final By BUTTON = By.id("openModalBtn");
    private final By WINDOWMODAL = By.id("closeModal");

    @BeforeEach
    public void webDriverStart() {
        driver = new WebDriverFactory().getDriver(BrowserMode.KIOSK);
        String baseUrl = System.getProperty("base.url");
        driver.get(baseUrl);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openModalWindow() {
        driver
                .findElement(BUTTON)
                .click();

        String textWindowModal = driver
                .findElement(WINDOWMODAL)
                .getText();

        Assertions.assertEquals("×", textWindowModal, "The modal window didn't open");
    }
}
