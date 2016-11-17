package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Sai on 17.11.2016.
 */
public class ContactDetailInfoTests extends TestBase{


  @Test

  public void testContactDetail(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDetailInfo = app.contact().InfoDetailForm(contact);

    assertThat(mergeContactInfo(contact), equalTo(cleaned(contactDetailInfo.getDetails())));
  }

  private static String  cleaned(String details) {
    return details.replaceAll("\\S","").replaceAll("[-()]","").replaceAll("www.gmail.com", "")
            .replaceAll("www.mail.com", "").replaceAll("H","").replaceAll("M","")
            .replaceAll("W","");
  }


  private String mergeContactInfo(ContactData contact) {
    return Arrays.asList(contact.getFirstname(),contact.getLastname(),contact.getAddress(),contact.getAllEmails(),
    contact.getAllPhones()).stream().filter((s)->!s.equals("")).collect(Collectors.joining("\n"));
    
  }


}
