package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageCopyPhotoToBoard extends PerentPage {
    public PageCopyPhotoToBoard(WebDriver wb) {
        super(wb);
    }

    HomePage homePage = new HomePage(wb);

    @FindBy(xpath = ".//article[@class = 'gallery-mosaic-asset__boards add-to-board action']")
    private WebElement hoverPlus;

    @FindBy(className = "action-toolbox")
    private WebElement toolbox;

    By idPhoto = By.xpath(".//a");


    public List<WebElement> resultPhotos = wb.findElements(By.xpath(".//gi-asset[@class='gallery-mosaic-asset']"));


    public boolean isPhotosExist() {
        if (resultPhotos.size() > 0) {
            return true;
        }
        return false;
    }

    @Step
    public SaveToBoard addPhotosToBoard(int slot) {
        WebElement photo = resultPhotos.get(slot - 1);
        homePage.hover(photo);
        homePage.hover(hoverPlus);
        toolbox.click();
        return new SaveToBoard(wb);
    }

    @Step
    public String getPhotoId(int slot) {
        List<WebElement> resultPhotos = wb.findElements(By.xpath(".//gi-asset[@class='gallery-mosaic-asset']"));
        return resultPhotos.get(slot - 1)
                .findElement(idPhoto)
                .getAttribute("data-asset-id");
    }
}