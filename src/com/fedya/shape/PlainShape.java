package com.fedya.shape;

public abstract class PlainShape extends ImmutableShape {

  public PlainShape(double firstDim, double secondDim) {
    this.firstDim = firstDim;
    this.secondDim = secondDim;
    metrics = computeMetrics();
  }

  public double getArea() {
    return getMetrics();
  }

  protected double firstDim;
  protected double secondDim;
}
