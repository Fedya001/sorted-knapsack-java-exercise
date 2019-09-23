package com.fedya.shape;

public class Cylinder extends VolumeShape {

  public Cylinder(double base_radius, double height) {
    super(0.0, base_radius, height);
  }

  public double getBaseRadius() {
    return secondDim;
  }

  public double getHeight() {
    return thirdDim;
  }

  @Override
  public String toString() {
    return "Cylinder { base_radius = " + Double.toString(getBaseRadius()) +
      ", height = " + Double.toString(getHeight()) + ", " + super.toString() + "}";
  }

  @Override
  protected double computeMetrics() {
    return Math.PI * getBaseRadius() * getBaseRadius() * getHeight();
  }
}
