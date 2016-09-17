package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.gotoAddnewPage();
    app.fillContactForm(new ContactDate("Sasha_s", "Sasha_b", "Moscow", "123456789", "qwe@gmail.com"));
    app.enterContactCreation();
    app.returnToHomePage();
  }


}
