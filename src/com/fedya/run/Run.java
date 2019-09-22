package com.fedya.run;

import com.fedya.shape.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CyclicBarrier;

public class Run {
  public static void main(String[] args) {
    ArrayList<ImmutableShape> shapes = new ArrayList<ImmutableShape>() {
      {
        add(new Rectangle(15.0,15.0));
        add(new Circle(2.0));
        add(new Parallelepiped(1.0,2.0,3.0));
        add(new Сylinder(1.0,2.0));
      }
    };

    for (ImmutableShape shape : shapes) {
      System.out.println(shape);
    }

    Collections.sort(shapes);
    System.out.println(shapes);
  }
}
