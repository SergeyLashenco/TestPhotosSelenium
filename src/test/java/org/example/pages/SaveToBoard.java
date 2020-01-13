package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SaveToBoard extends PerentPage {
    public SaveToBoard(WebDriver wb) {
        super(wb);
    }

    PageCopyPhotoToBoard pageCopyPhotoToBoard = new PageCopyPhotoToBoard(wb);
    MiniPageBoard miniPageBoard = new MiniPageBoard(wb);

    @FindBy(xpath = ".//a[@class='choose-board']")
    private WebElement chooseBoard;

    @FindBy(xpath = ".//li[@class='board-item ng-scope']")
    private WebElement newHoverNameBoard;

    @FindBy(className = "save-bubble")
    private WebElement saveBubble;

    @FindBy(xpath = ".//a[@class='button open-board']")
    private WebElement buttonGoToPageBoard;

    List<WebElement> boardsName = wb.findElements(By.xpath(".//ul/li[@class='board-item ng-scope']"));

    @Step
    public PageCopyPhotoToBoard savePhotoToBoard(String boardName) throws InterruptedException {
        if (chooseBoard.isDisplayed()) {
            chooseBoard.click();
        }
        boardsName.stream().filter(board -> board.getText().equals(boardName)).findFirst().orElse(newHoverNameBoard).click();

        return new PageCopyPhotoToBoard(wb);
    }

    @Step
    public PageBoard goToPageBoard() {
        buttonGoToPageBoard.click();
        return new PageBoard(wb);
    }

}
