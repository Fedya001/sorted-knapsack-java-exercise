package com.fedya.shape;

public class Сylinder extends VolumeShape {
  public Сylinder(double base_radius, double height) {
    super(base_radius, height, 0.0);
  }

  public double getBaseRadius() {
    return firstDim;
  }

  public double getHeight() {
    return secondDim;
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
