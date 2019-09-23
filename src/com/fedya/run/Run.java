package com.fedya.run;

import com.fedya.converter.PlainShapeConverter;
import com.fedya.exception.ConverterUnknownTypeException;
import com.fedya.exception.KnapsackOverflowException;
import com.fedya.exception.ReaderUnknownTypeException;
import com.fedya.knapsack.SortedKnapsack;
import com.fedya.shape.*;
import com.fedya.utils.ImmutableShapeReader;
import com.fedya.utils.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Run {

  public static void main(String[] args) {
    final double knapsackVolume = 15.0;

    // 1. test SortedKnapsack
    try {
      SortedKnapsack knapsack = new SortedKnapsack(knapsackVolume) {
        {
          add(new Parallelepiped(1.0, 2.0, 3.0));
          add(new Cylinder(1.0, 2.0));
          add(new Cylinder(0.5, 3.0));
        }
      };

      System.out.println(knapsack);
      knapsack.add(new Parallelepiped(1.0, 1.0, 1.0));
      System.out.println(knapsack);
    } catch (KnapsackOverflowException e) {
      e.printStackTrace();
    }

    // 2. test PlainShapeConverter
    PlainShapeConverter<Rectangle> rectangleConverter =
      new PlainShapeConverter<Rectangle>(new Pair<Double, Double>(0.0, 1.0));
    PlainShapeConverter<Circle> circleConverter =
      new PlainShapeConverter<Circle>(new Pair<Double, Double>(1.0, 2.0));
    PlainShapeConverter<DummyPlainShape> dummyConverter =
      new PlainShapeConverter<DummyPlainShape>(new Pair<Double, Double>(1.0, 1.0));

    try {
      System.out.println(rectangleConverter.stretchShape(new Rectangle(4.0, 1.5)));
      System.out.println(circleConverter.stretchShape(new Circle(5.0)));

      System.out.println(dummyConverter.stretchShape(new DummyPlainShape()));
    } catch (ConverterUnknownTypeException e) {
      e.printStackTrace();
    }

    // 3. test ImmutableShapeReader
    ImmutableShapeReader shapeReader = new ImmutableShapeReader();

    try {
      ImmutableShape shape = shapeReader.readShape();
      System.out.println(shape);
    } catch (ReaderUnknownTypeException e) {
      e.printStackTrace();
    }
  }
}
