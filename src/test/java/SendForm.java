//Открыть Chrome в режиме полного экрана
//Перейти на ресурс
//В форму ввести имя и почту, нажать «Отправить»
//В поле динамическое сообщение (на зеленом фоне) появится сообщение в
// формате: «Форма отправлена с именем: фыв и email: asdf@sdfg.rt».

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SendForm {
    private WebDriver driver;
    private final By FIELDNAME = By.id("name");
    private final By FIELDEMAIL = By.id("email");
    private final By BUTTON = By.cssSelector("[type = 'submit']");
    private final By MESSAGE = By.id("messageBox");

    @BeforeEach
    public void webDriverStart() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
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
    public void clickSend() {
        String name = "Jon";
        String email = "asdf@sdfg.rt";

        WebElement textNameField = driver.findElement(FIELDNAME);
        textNameField.sendKeys(name);

        WebElement textEmailField = driver.findElement(FIELDEMAIL);
        textEmailField.sendKeys(email);

        String expectedMessage = "Форма отправлена с именем: %s и email: %s"
                .formatted(textNameField.getAttribute("value"),
                        textEmailField.getAttribute("value"));

        driver
                .findElement(BUTTON)
                .click();

        String someText = driver.findElement(MESSAGE).getText();

        Assertions.assertEquals(expectedMessage, someText, "The text format doesn't match what is expected");
    }
}
