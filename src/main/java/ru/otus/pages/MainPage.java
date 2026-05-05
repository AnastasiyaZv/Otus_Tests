package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbsBasePage{

    private static final String TEXT_INPUT = "textInput";
    private static final String BUTTON_OPEN_WINDOW = "openModalBtn";
    private static final String MODAL_WINDOW = "modal-content";
    private static final String TEXT_NAME_FORM = "name";
    private static final String TEXT_EMAIL_FORM = "email";
    private static final String BUTTON_FORM = "[type = 'submit']";
    private static final String MESSAGE_DYNAMIC_FORM = "messageBox";


    @FindBy (id = TEXT_INPUT)
    private WebElement textInputField;

    @FindBy (id = BUTTON_OPEN_WINDOW)
    private WebElement openModalButton;

    @FindBy (className = MODAL_WINDOW)
    private WebElement modalWindow;

    @FindBy (id = TEXT_NAME_FORM)
    private WebElement textNameForm;

    @FindBy (id = TEXT_EMAIL_FORM)
    private WebElement textEmailForm;

    @FindBy (css = BUTTON_FORM)
    private WebElement formSendButton;

    @FindBy (id = MESSAGE_DYNAMIC_FORM)
    private WebElement messageDynamicForm;

    public MainPage(WebDriver driver) {
        super(driver, "");
    }

    public MainPage enterTextInput(String text){
        textInputField.sendKeys(text);
        return this;
    }

    public String getEnteredTextFromField(){
        return textInputField.getAttribute("value");
    }

    public boolean isTextFieldMatching(String expectedText){
        String actualText = getEnteredTextFromField();
        return actualText.equals(expectedText);
    }

    public MainPage clickButtonOpenModal(){
        openModalButton.click();
        return this;
    }

    public boolean isModalWindowOpen(){
        return modalWindow.isDisplayed();
    }

    public void enterForm(String name, String email){
        textNameForm.sendKeys(name);
        textEmailForm.sendKeys(email);
    }

    public void clickButtonSendForm(){
        formSendButton.click();
    }

    public boolean isMessageDynamicMatching(String name, String email){
        String expectedMessage = String.format("Форма отправлена с именем: %s и email: %s",name, email);
        String text = messageDynamicForm.getText();
        return text.equals(expectedMessage);
    }
}
