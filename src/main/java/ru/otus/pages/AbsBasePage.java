package ru.otus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public abstract class AbsBasePage {

    protected WebDriver driver;
    private String baseUrl = System.getProperty("base.url");

    public AbsBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get(baseUrl);
    }
}

