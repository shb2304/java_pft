package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sai on 16.09.2016.
 */
public class DistanceTests {
  @Test
  //public void testArea(){
  //  Square s =new Square(5);
  //  assert s.area() ==25
 // }

  public void testDistance(){
    Point p1= new Point(2, 0);
    Point p2= new Point(3, 0);
    Assert.assertEquals(p2.distance(p1), 1.0);
  }
}
