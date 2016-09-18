package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoAddnewPage();
    app.getContactHelper().fillContactForm(new ContactDate("Sasha_s", "Sasha_b", "Moscow", "+7(123)4567899", "qwe@gmail.com"));
    app.getContactHelper().enterContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
