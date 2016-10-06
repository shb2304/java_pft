package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

import java.util.List;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactDate("Sasha_s", "Sasha_b", "Moscow", "+7(123)4567899",
            "qwe@gmail.com", "test_s1"),true);
    List<ContactDate> after = app.getContactHelper().getContactList();
   Assert.assertEquals(after.size(),before.size()+1);
  }


}
