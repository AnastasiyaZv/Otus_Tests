import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Открыть Chrome в headless режиме
//Перейти на ресурс
//В поле ввода текста ввести ОТУС
//Проверить, что текст соответствует введенному

public class EnterTextInField {

    private WebDriver driver;
    private final By FIELD = By.id("textInput");

    @BeforeEach
    public void webDriverStart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
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
    public void enterStringValueInField() {
        String text = "123";
        WebElement textField = driver.findElement(FIELD);
        textField.sendKeys(text);

        Assertions.assertEquals(text, textField.getAttribute("value"), "Expected text = " + text);
    }
}
