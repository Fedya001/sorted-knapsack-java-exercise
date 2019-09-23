package com.fedya.shape;

public class Parallelepiped extends VolumeShape {

  public Parallelepiped(double width, double height, double depth) {
    super(width, height, depth);
  }

  public double getHeight() {
    return firstDim;
  }

  public double getWidth() {
    return secondDim;
  }

  public double getDepth() {
    return thirdDim;
  }

  @Override
  public String toString() {
    return "Parallelepiped { width = " + Double.toString(getWidth()) +
      ", height = " + Double.toString(getHeight()) +
      ", depth = " + Double.toString(getDepth()) + ", " + super.toString() + "}";
  }

  @Override
  protected double computeMetrics() {
    return getWidth() * getHeight() * getDepth();
  }
}
