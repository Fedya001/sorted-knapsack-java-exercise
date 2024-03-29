package com.fedya.shape;

public class Cylinder extends VolumeShape {

  public Cylinder(double baseRadius, double height) {
    super(0.0, baseRadius, height);
  }

  public double getBaseRadius() {
    return secondDim;
  }

  public double getHeight() {
    return thirdDim;
  }

  @Override
  public String toString() {
    return "Cylinder {baseRadius = " + DECIMAL_FORMAT.format(getBaseRadius()) +
      ", height = " + DECIMAL_FORMAT.format(getHeight()) + ", " + super.toString() + "}";
  }

  @Override
  protected double computeMetrics() {
    return Math.PI * getBaseRadius() * getBaseRadius() * getHeight();
  }
}
