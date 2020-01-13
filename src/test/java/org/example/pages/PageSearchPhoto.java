package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSearchPhoto extends PerentPage {
    public PageSearchPhoto(WebDriver wb) {
        super(wb);
    }

    @FindBy(xpath = ".//input[@class='non-default phrase']")
    public WebElement searchPhoto;

    @Step
    public PageCopyPhotoToBoard searchPhotos(String desiredFhoto) {
        searchPhoto.click();
        searchPhoto.clear();
        searchPhoto.sendKeys(desiredFhoto);
        searchPhoto.sendKeys(Keys.ENTER);
        return new PageCopyPhotoToBoard(wb);
    }

}
