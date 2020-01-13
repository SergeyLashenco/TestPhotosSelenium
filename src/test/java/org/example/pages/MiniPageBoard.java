package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MiniPageBoard extends PerentPage {
    public MiniPageBoard(WebDriver wb) {
        super(wb);
    }

    @FindBy(id = "open_board")
    public WebElement openBord;

    @FindBy(xpath = ".//a[@class ='board-link create-board-link']")
    private WebElement creatBoard;
    @FindBy(name = "boardname")

    private WebElement boarName;
    @FindBy(xpath = ".//a [@class = 'button' and  @type = 'submit']")
    private WebElement buttonCreate;

    @FindBy(xpath = ".//a[@class='modalClose close-reveal-modal']")
    private WebElement bord;

    public List<WebElement> listBoard;

    @Step
    public HomePage createBoard(String name) {
        creatBoard.click();
        boarName.sendKeys(name);
        buttonCreate.click();
        return new HomePage(wb);
    }

    @Step
    public boolean isBoardExist(String name) throws InterruptedException {
        openBord.click();
        Thread.sleep(500);
        try {
            listBoard = wb.findElements(By.xpath(".//ul/li/a[@class = 'board-item-link']"));
            for (WebElement exist : listBoard
            ) {
                String boardName = exist.findElement(By.tagName("span")).getAttribute("textContent");
                if (boardName.equals(name)) {
                    return true;
                }
            }
        } catch (Throwable t) {
            return false;
        }
        return false;
    }

    List<WebElement> boardPhotoId;

    @Step
    public boolean isPhotoAdd(String nameBoard, String idPhoto) throws InterruptedException {
        openBord.click();
        // Thread.sleep(200);
        if (isBoardExist(nameBoard)) {
            listBoard.stream().filter(board -> board.getText().equals(nameBoard)).findFirst().get().click();
        }
        boardPhotoId = wb.findElements(By.xpath(".//span[@ng-controller]"));
        for (WebElement photoid : boardPhotoId
        ) {
            String id = photoid.findElement(By.xpath(".//ul/li[@carousel-loaded]")).getAttribute("data-asset-id");
            if (idPhoto.equals(id)) return true;
        }
        return false;
    }
}