package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerentPage {
    protected WebDriver wb;
    protected WebDriverWait wait;


    public PerentPage(WebDriver wb) {
        this.wb = wb;
        wait = new WebDriverWait(wb, 10);
        PageFactory.initElements(wb, this);
    }

    protected boolean isElementpresent(By locator) {
        try {
            wb.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
