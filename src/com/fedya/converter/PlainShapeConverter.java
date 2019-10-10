package com.fedya.converter;

import com.fedya.exception.ConverterUnknownTypeException;
import com.fedya.shape.*;
import com.fedya.utils.Pair;
import java.util.Random;

public class PlainShapeConverter<T extends PlainShape> {
  private Pair<Double, Double> stretchRange;

  public PlainShapeConverter(Pair<Double, Double> stretchRange) {
    this.stretchRange = stretchRange;
  }

  public Pair<Double, Double> getStretchRange() {
    return stretchRange;
  }

  public void setStretchRange(Pair<Double, Double> stretchRange) {
    this.stretchRange = stretchRange;
  }

  // This code smells really bad, but I didn't invent anything better
  public VolumeShape stretchShape(T plainShape) throws ConverterUnknownTypeException {
    double randomDepth = new Random().nextDouble() *
      (stretchRange.second - stretchRange.first) + stretchRange.first;

    if (plainShape instanceof Circle) {
      Circle circle = (Circle) plainShape;
      return new Cylinder(circle.getRadius(), randomDepth);
    } else if (plainShape instanceof Rectangle) {
      Rectangle rectangle = (Rectangle) plainShape;
      return new Parallelepiped(rectangle.getWidth(), rectangle.getHeight(), randomDepth);
    } else {
      throw new ConverterUnknownTypeException(plainShape);
    }
  }
}
