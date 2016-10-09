package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Sasha_s", "Sasha_b", "Moscow", "+7(123)4567899",
            "qwe@gmail.com", "test_s1");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
   Assert.assertEquals(after.size(),before.size()+1);


  int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    contact.setId(max);
    before.add(contact);
     Assert.assertEquals(new LinkedHashSet<Object>(before),new LinkedHashSet<Object>(after));


  }
}
