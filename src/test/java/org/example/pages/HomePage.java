package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PerentPage {
    public HomePage(WebDriver wb) {
        super(wb);
    }

    @FindBy(xpath = ".//a[@class = 'account' and  @data-nav ='nav=nav_SignIn']")
    private WebElement signIn;
    //.//a[@class='modalClose close-reveal-modal']
    @FindBy(xpath = ".//a[@class='modalClose close-reveal-modal']")
    private WebElement bord;

    @FindBy(xpath = ".//li[@class = 'wide-header right-off-canvas-toggle-menu' and text()='Account']")
    private WebElement account;

    @FindBy(id = "hypSignOut")
    private WebElement signOut;

    @FindBy(id = "open_board")
    private WebElement openBord;

    @FindBy(xpath = ".//a[@data-nav = 'nav=nav_Photos' and @title='Photos']")
    private WebElement goToPhotos;

    public WebElement getAccount() {
        return account;
    }


    //.//*[@id='geo-promo-modal']//a[@class = 'modalClose close-reveal-modal']
    @Step
    public HomePage open() {
        wb.get("https://www.istockphoto.com/");
        return this;
    }

    @Step
    public PageSignIn goToPageSignIn() {
        if (bord.isDisplayed()) {
            wait.until(ExpectedConditions.elementToBeClickable(bord));
            bord.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(signIn));
        signIn.click();
        return new PageSignIn(wb);
    }

    @Step
    public void hover(WebElement element) {
        try {
            Actions builder = new Actions(wb);
            builder.moveToElement(element).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step
    public MiniPageBoard goToMiniPageBoard() {
        hover(openBord);
        return new MiniPageBoard(wb);
    }

    @Step
    public PageSearchPhoto goToPageSearchPhoto() {
        goToPhotos.click();
        return new PageSearchPhoto(wb);
    }

    @Step
    public void signOut() {
        account.click();
        signOut.click();
    }
}
