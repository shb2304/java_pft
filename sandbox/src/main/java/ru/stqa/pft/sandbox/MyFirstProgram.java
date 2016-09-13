package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");



    Point p1= new Point(4, 1);
    Point p2= new Point(7, 5);
    System.out.println("Расстояние между точками p1("+p1.x+";"+p1.y+")" + "и" + "p2("+p2.x+";"+p2.y+")" + "=" + distance(p1,p2));



  }
  public static void hello(String word) {
   System.out.println("Hello," + word + "!");
  }



  public static double distance(Point p1, Point p2) {
    return Math.sqrt (Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
  }
}