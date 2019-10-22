package com.fedya.shape;

public class Rectangle extends PlainShape {

  public Rectangle(double width, double height) {
    super(width, height);
  }

  public double getWidth() {
    return firstDim;
  }

  public double getHeight() {
    return secondDim;
  }

  @Override
  public String toString() {
    return "Rectangle {width = " + DECIMAL_FORMAT.format(getWidth()) +
      ", height = " + DECIMAL_FORMAT.format(getHeight()) + ", " + super.toString() + "}";
  }

  @Override
  protected double computeMetrics() {
    return getWidth() * getHeight();
  }
}
