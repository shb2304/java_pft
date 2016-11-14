package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Sasha_s").withLastname("Sasha_b").withAddress("Moscow").
            withMobile("+7(123)4567899").withEmail("qwe@gmail.com").withGroup("test_s1");
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
   Assert.assertEquals(after.size(),before.size()+1);


  int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    contact.withId(max);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2)-> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }
}
