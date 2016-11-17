package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sai on 18.09.2016.
 */
public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstname("Sasha_s").withLastname("Sasha_b").withAddress("Moscow").
              withMobile("+7(123)4567899").withEmail("qwe@gmail.com").withGroup("test_s1"));}
  }

  @Test
public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact= before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Sasha_s").withLastname("Sasha_b");
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
