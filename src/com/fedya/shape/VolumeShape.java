package com.fedya.shape;

public abstract class VolumeShape extends ImmutableShape {
  VolumeShape(double firstDim, double secondDim, double thirdDim) {
    this.firstDim = firstDim;
    this.secondDim = secondDim;
    this.thirdDim = thirdDim;
    metrics = computeMetrics();
  }

  public double getVolume() {
    return getMetrics();
  }

  protected double firstDim;
  protected double secondDim;
  protected double thirdDim;
}
