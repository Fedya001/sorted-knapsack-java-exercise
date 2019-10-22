package com.fedya.utils;

import com.fedya.exception.UnknownShapeType;
import com.fedya.shape.Circle;
import com.fedya.shape.Cylinder;
import com.fedya.shape.ImmutableShape;
import com.fedya.shape.Parallelepiped;
import com.fedya.shape.Rectangle;
import com.fedya.shape.ShapeType;
import java.util.Random;

public class ShapeGenerator {

  private Random generator;
  private Pair<Double, Double> valueRange;

  ShapeGenerator(Pair<Double, Double> valueRange) {
    generator = new Random();
    this.valueRange = valueRange;
  }

  ImmutableShape nextShape() {
    ShapeType[] shapeValues = ShapeType.values();
    ShapeType type = shapeValues[generator.nextInt() % shapeValues.length];

    switch (type) {
      case CIRCLE:
        return new Circle(getBoundedRandomValue());
      case CYLINDER:
        return new Cylinder(getBoundedRandomValue(), getBoundedRandomValue());
      case RECTANGLE:
        return new Rectangle(getBoundedRandomValue(), getBoundedRandomValue());
      case PARALLELEPIPED:
        return new Parallelepiped(getBoundedRandomValue(),
          getBoundedRandomValue(), getBoundedRandomValue());
      default:
        throw new UnknownShapeType(type, "ShapeGenerator");
    }
  }

  public void setGeneratorRange(Pair<Double, Double> valueRange) {
    this.valueRange = valueRange;
  }

  private double getBoundedRandomValue() {
    return generator.nextDouble() *
      (valueRange.second - valueRange.first) + valueRange.first;
  }
}
