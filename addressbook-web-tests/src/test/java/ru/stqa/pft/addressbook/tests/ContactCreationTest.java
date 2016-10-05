package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactDate("Sasha_s", "Sasha_b", "Moscow", "+7(123)4567899",
            "qwe@gmail.com", "test_s1"),true);

  }


}
