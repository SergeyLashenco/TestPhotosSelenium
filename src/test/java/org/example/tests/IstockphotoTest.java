package org.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IstockphotoTest extends TestBase {
   String photoId;

   @Test(priority = 0 , description = "Open site and login")
   public void validLogin() {
      app.homePage().open().goToPageSignIn();
      app.pageSignIn().login("sergeylashenco@gmail.com", "11111111s");
      Assert.assertTrue(app.homePage().getAccount().isDisplayed());
   }

   @Test(priority = 1 , description = "Create new Board (name Serge)")
   public void createBoard() throws InterruptedException {
      app.homePage().goToMiniPageBoard().createBoard("Serge");
      Assert.assertTrue(app.miniPageBoard().isBoardExist("Serge"));
   }

   @Test(priority = 2, description = "Поиск фото и добавления выбранного фото на ранее созданный боард")
   public void searchAndCopyPhotoToBoard() throws InterruptedException {
      app.homePage().goToPageSearchPhoto().searchPhotos("winter").addPhotosToBoard(10);
      photoId = app.searchPhotoResult().getPhotoId(10);
      app.saveToBoard().savePhotoToBoard("Serge");
      Assert.assertTrue(app.miniPageBoard().isPhotoAdd("Serge", photoId));
   }

   @Test(priority = 3, description = "Delete Photo")
   public void deletePhoto() {
      app.saveToBoard().goToPageBoard().deletePhoto(photoId);
      Assert.assertTrue(app.pageBoard().photoNotInBoard(photoId));
   }

   @Test(priority = 4, description = "Delete Board and SignOut")
   public void deleteBoard() {
      app.pageBoard().deleteBoard();
      app.homePage().signOut();
   }

}