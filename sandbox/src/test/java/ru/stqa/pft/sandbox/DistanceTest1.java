package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sai on 17.09.2016.
 */
public class DistanceTest1 {
  @Test
  public void testDistance() {
    Point p1 = new Point(2, 0);
    Point p2 = new Point(2, 0);
    Assert.assertEquals(p2.distance(p1), 0.0);


  }
}