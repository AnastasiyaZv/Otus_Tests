package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public WebDriver getDriver(BrowserMode mode){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        switch (mode){
            case KIOSK -> {
                options.addArguments("--kiosk");
                break;
            }
            case HEADLESS -> {
                options.addArguments("--headless");
                break;
            }
            case FULLSCREEN -> {
                options.addArguments("--start-fullscreen");
                break;
            }
        }
        return new ChromeDriver(options);
    }

}
