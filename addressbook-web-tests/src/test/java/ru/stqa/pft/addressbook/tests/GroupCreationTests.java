package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupDate("test_s1", "test_s2", "test_s3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
