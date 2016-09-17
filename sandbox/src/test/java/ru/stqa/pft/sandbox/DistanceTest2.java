package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sai on 17.09.2016.
 */
public class DistanceTest2 {

  @Test
  public void testDistance() {
    Point p1 = new Point(-2, 1);
    Point p2 = new Point(-3, 1);
    Assert.assertEquals(p2.distance(p1), 1.0);// отрицательные координаты
  }
}
