package org.example.app;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Application {
   private WebDriver wb;
   private static String browser;
   private  HomePage homePage;
   private  PageSignIn pageSignIn;
   private PageBoard pageBoard;
   private PageSearchPhoto pageSearchPhoto;
   private PageCopyPhotoToBoard pageCopyPhotoToBoard;
   private MiniPageBoard miniPageBoard;
   private SaveToBoard saveToBoard;


   public Application(String browser) {
      this.browser = browser;
   }

   public Application(WebDriver wb) {
      this.wb  = wb;
   }

   public void init()  {
      initDriver();
      wb.manage().window().maximize();
      wb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      homePage = new HomePage(wb);
      pageSignIn = new PageSignIn(wb);
      pageBoard = new PageBoard(wb);
      pageSearchPhoto = new PageSearchPhoto(wb);
      pageCopyPhotoToBoard = new PageCopyPhotoToBoard(wb);
      miniPageBoard = new MiniPageBoard(wb);
      saveToBoard = new SaveToBoard(wb);
   }

   private void initDriver()  {
         if (browser == null || "chrome".equals(browser.toLowerCase())) {
            File file = new File("./src/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            wb = new ChromeDriver();
         } else if ("firefox".equals(browser)) {
            File file = new File("./src/drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addArguments("--disable-notifications");
            wb = new FirefoxDriver();
         }
   }


   public void stop() {
      wb.quit();
   }


   public static String  getBrowser() {
      return browser;
   }

   public HomePage homePage() {
      return homePage;
   }

   public PageSignIn pageSignIn() {
      return pageSignIn;
   }

   public PageBoard pageBoard(){return pageBoard;}

   public PageSearchPhoto searchPhoto() {
      return pageSearchPhoto;
   }

   public PageCopyPhotoToBoard searchPhotoResult() {
      return pageCopyPhotoToBoard;
   }

   public MiniPageBoard miniPageBoard() {
      return miniPageBoard;
   }

   public SaveToBoard saveToBoard() {
      return saveToBoard;
   }
}


