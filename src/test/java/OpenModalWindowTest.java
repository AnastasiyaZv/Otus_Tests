import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.factory.BrowserMode;

//Открыть Chrome в режиме киоска
//Перейти на ресурс
//Нажать на «Открыть модальное окно»
//Проверить, что открылось модальное окно

public class OpenModalWindowTest extends AbsTests {

    public OpenModalWindowTest() {
        super(BrowserMode.KIOSK);
    }

    @Test
    public void checkOpenModalWindow() {
        mainPage
                .open();

        boolean isModalOpen = mainPage
                .clickButtonOpenModal()
                .isModalWindowOpen();

        Assertions.assertTrue(isModalOpen, "Модальное окно не открыто");
    }
}
