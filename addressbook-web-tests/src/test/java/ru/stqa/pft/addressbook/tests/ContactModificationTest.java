package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Sai on 18.09.2016.
 */
public class ContactModificationTest extends TestBase{

  @Test
public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Sasha_s", "Sasha_b", "Moscow", "+7(123)4567899",
              "qwe@gmail.com", "test_s1"));}
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Sasha_s", "Sasha_b", "Moscow",
            "+7(123)4567899", "qwe@gmail.com", null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

  }
}
