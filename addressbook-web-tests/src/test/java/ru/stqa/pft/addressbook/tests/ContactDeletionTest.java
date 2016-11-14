package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withFirstname("Sasha_s").withLastname("Sasha_b").withAddress("Moscow").
              withMobile("+7(123)4567899").withEmail("qwe@gmail.com").withGroup("test_s1"));}
  }
  @Test
  public void testContactDeletion() {

    List<ContactData> before = app.contact().list();
    int index=before.size()-1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }

}
