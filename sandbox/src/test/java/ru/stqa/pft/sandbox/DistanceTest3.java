package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sai on 17.09.2016.
 */
public class DistanceTest3 {

  @Test
  public void testDistance() {
    Point p1 = new Point(2, 0);
    Point p2 = new Point(3, 0);
    Assert.assertEquals(p2.distance(p1), p1.distance(p2)); //тут я сравниваю , что расстояние от точки р1 до р2 равно расстоянию от р2 до р1
  }
}