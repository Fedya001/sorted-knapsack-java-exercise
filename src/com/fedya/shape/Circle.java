package com.fedya.shape;

public class Circle extends PlainShape {

  public Circle(double radius) {
    super(0.0, radius);
  }

  public double getRadius() {
    return secondDim;
  }

  @Override
  public String toString() {
    return "Circle { radius = " + DECIMAL_FORMAT.format(getRadius()) + ", " + super.toString() + "}";
  }

  @Override
  protected double computeMetrics() {
    return Math.PI * getRadius() * getRadius();
  }
}
