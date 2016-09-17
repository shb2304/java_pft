package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupDate("test_s1", "test_s2", "test_s3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
