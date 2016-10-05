package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by Sai on 18.09.2016.
 */
public class ContactModificationTest extends TestBase{

  @Test
public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactDate("Sasha_s", "Sasha_b", "Moscow",
            "+7(123)4567899", "qwe@gmail.com", null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();


  }
}
