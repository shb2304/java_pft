package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {

    gotoAddnewPage();
    fillContactForm(new ContactDate("Sasha_s", "Sasha_b", "Moscow", "123456789", "qwe@gmail.com"));
    enterContactCreation();
    returnToHomePage();
  }


}
