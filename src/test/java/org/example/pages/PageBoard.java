package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageBoard extends PerentPage {
    public PageBoard(WebDriver wb) {
        super(wb);
    }

    HomePage homePage = new HomePage(wb);

    @FindBy(xpath = ".//a[@class='delete-board ng-scope']")
    private WebElement buttonDeleteBoard;

    @FindBy(xpath = ".//span[@class='remove']")
    private WebElement buttonDeletePhotos;


    List<WebElement> photosInBoard = wb.findElements(By.xpath("//div[@class='board-item-content' and @ng-class]"));

    @Step
    public WebElement searchPhoto(String iD) {
        for (WebElement photo : photosInBoard
        ) {
            photo.findElement(By.xpath(".//span[@class='asset-id ng-binding']")).getText().equals(iD);
            return photo;
        }
        return null;
    }

    @Step
    public void deletePhoto(String iD) {
        WebElement deletePhotos = searchPhoto(iD);
        homePage.hover(deletePhotos);
        buttonDeletePhotos.click();
    }

    @Step
    public boolean photoNotInBoard(String iD) {
        if (searchPhoto(iD) == null) {
            return true;
        }
        return false;
    }

    @Step
    public PageBoard deleteBoard() {
        buttonDeleteBoard.click();
        Alert alert = wb.switchTo().alert();
        alert.accept();
        return this;
    }

    public boolean checkRemoveBoadr() {
        if (!buttonDeleteBoard.isDisplayed()) {
            return true;
        }
        return false;
    }
}


/*
 <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
 */