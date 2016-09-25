package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactDate;

/**
 * Created by Sai on 18.09.2016.
 */
public class ContactHelper extends HelperBase{


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void enterContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactDate contactDate) {
    type(By.name("firstname"),contactDate.getFirstname());
    type(By.name("lastname"),contactDate.getLastname());
    type(By.name("address"),contactDate.getAddress());
    type(By.name("mobile"),contactDate.getMobile());
    type(By.name("email"),contactDate.getEmail());

  }

  public void deleteSelectedContact() {
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact() {

    click(By.name("selected[]"));
  }

  public void confirmDeletionContact() {

    AlertAssept();
  }

  public void initContactModification() {

    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));


  }


  public void submitContactModification() {
    click(By.name("update"));
  }
}
