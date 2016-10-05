package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

  public void fillContactForm(ContactDate contactDate, boolean creation) {
    type(By.name("firstname"),contactDate.getFirstname());
    type(By.name("lastname"),contactDate.getLastname());
    type(By.name("address"),contactDate.getAddress());
    type(By.name("mobile"),contactDate.getMobile());
    type(By.name("email"),contactDate.getEmail());

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

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
