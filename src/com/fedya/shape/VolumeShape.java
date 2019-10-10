package com.fedya.shape;

public abstract class VolumeShape extends ImmutableShape {

  protected double firstDim;
  protected double secondDim;
  protected double thirdDim;

  public VolumeShape(double firstDim, double secondDim, double thirdDim) {
    this.firstDim = firstDim;
    this.secondDim = secondDim;
    this.thirdDim = thirdDim;
    metrics = computeMetrics();
  }

  public double getVolume() {
    return getMetrics();
  }
}
