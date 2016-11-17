package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sai on 17.11.2016.
 */
public class ContactDataTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstname("Sasha_s").withLastname("Sasha_b").withAddress("Moscow").
            withHome("44-44-44").withMobile("+7(123)4567899").withWork("456456").withEmail("qwe@gmail.com").withEmail2("aaa@gmail.com"));}
  }

  @Test

  public void testContactData() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().InfoFormEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFormEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2()).stream()
            .filter((s)->!s.equals(""))
            //.map(ContactDataTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(),contact.getMobile(),contact.getWork()).stream()
            .filter((s)->!s.equals(""))
            .map(ContactDataTests::cleaned)
            .collect(Collectors.joining("\n"));

  }

  private static String cleaned(String phone) {
    return phone.replaceAll("\\S","").replaceAll("[-()]","");
  }

}
