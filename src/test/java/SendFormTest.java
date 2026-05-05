import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.factory.BrowserMode;

//Открыть Chrome в режиме полного экрана
//Перейти на ресурс
//В форму ввести имя и почту, нажать «Отправить»
//В поле динамическое сообщение (на зеленом фоне) появится сообщение в
// формате: «Форма отправлена с именем: фыв и email: asdf@sdfg.rt».

public class SendFormTest extends AbsTests {
    private static final String NAME_TEXT = "Jon";
    private static final String EMAIL_TEXT = "asdf@sdfg.rt";

    public SendFormTest() {
        super(BrowserMode.FULLSCREEN);
    }

    @Test
    public void checkMessageDynamic() {

        mainPage
                .open();
        mainPage
                .enterForm(NAME_TEXT, EMAIL_TEXT);

        mainPage
                .clickButtonSendForm();

        boolean messageDynamic = mainPage
                .isMessageDynamicMatching(NAME_TEXT, EMAIL_TEXT);

        Assertions.assertTrue(messageDynamic, "Текст не соответствует ожидаемому %s");
    }
}
