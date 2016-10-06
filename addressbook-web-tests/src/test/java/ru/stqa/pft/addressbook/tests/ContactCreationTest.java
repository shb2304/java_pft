package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("Sasha_s", "Sasha_b", "Moscow", "+7(123)4567899",
            "qwe@gmail.com", "test_s1"),true);
    List<ContactData> after = app.getContactHelper().getContactList();
   Assert.assertEquals(after.size(),before.size()+1);
  }


}
