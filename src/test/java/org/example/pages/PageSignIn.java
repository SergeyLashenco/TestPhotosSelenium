package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSignIn extends PerentPage {
    public PageSignIn(WebDriver wb) {
        super(wb);
    }

    @FindBy(id = ("new_session_username"))
    private WebElement login;
    @FindBy(id = ("new_session_password"))
    private WebElement pass;
    @FindBy(id = ("sign_in"))
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//div[@class = 'alert_box']")
    private WebElement errorMess;

    public WebElement getErrorMess() {
        return errorMess;
    }

    @Step
    public HomePage login(String name, String password) {
        login.clear();
        login.sendKeys(name);
        pass.clear();
        pass.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(wb);
    }

}
