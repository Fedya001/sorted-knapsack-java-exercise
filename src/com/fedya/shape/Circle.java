package com.fedya.shape;

public class Circle extends PlainShape {
  public Circle(double radius) {
    super(radius, 0.0);
  }

  public double getRadius() {
    return firstDim;
  }

  @Override
  public String toString() {
    return "Circle { radius = " + Double.toString(getRadius()) + ", " + super.toString() + "}";
  }

  @Override
  protected double computeMetrics() {
    return Math.PI * getRadius() * getRadius();
  }
}
