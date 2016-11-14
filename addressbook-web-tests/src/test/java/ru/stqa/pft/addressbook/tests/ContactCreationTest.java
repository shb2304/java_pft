package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Sasha_s").withLastname("Sasha_b").withAddress("Moscow").
            withMobile("+7(123)4567899").withEmail("qwe@gmail.com").withGroup("test_s1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
   Assert.assertEquals(after.size(),before.size()+1);

    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);

  }
}
