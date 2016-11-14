package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

/**
 * Created by Sai on 18.09.2016.
 */
public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withFirstname("Sasha_s").withLastname("Sasha_b").withAddress("Moscow").
              withMobile("+7(123)4567899").withEmail("qwe@gmail.com").withGroup("test_s1"));}
  }

  @Test
public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("Sasha_s").withLastname("Sasha_b");
    app.contact().modify(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
      Comparator<? super ContactData> byId = (g1,g2)-> Integer.compare(g1.getId(),g2.getId());
      before.sort(byId);
      after.sort(byId);
    Assert.assertEquals(before,after);

  }
}
