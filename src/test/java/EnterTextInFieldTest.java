import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.factory.BrowserMode;

//Открыть Chrome в headless режиме
//Перейти на ресурс
//В поле ввода текста ввести ОТУС
//Проверить, что текст соответствует введенному

public class EnterTextInFieldTest extends AbsTests {

    private final String TEST_TEXT = "123";

    public EnterTextInFieldTest() {
        super(BrowserMode.HEADLESS);
    }

    @Test
    public void checkEnterTextInField() {

        mainPage
                .open();
        mainPage
                .enterTextInput(TEST_TEXT)
                .getEnteredTextFromField();

        boolean isTextMatching = mainPage
                .isTextFieldMatching(TEST_TEXT);

        Assertions.assertTrue(isTextMatching,
                String.format("Введенный текст %s не соответствует отображаемому",
                        TEST_TEXT));
    }
}