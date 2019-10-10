package com.fedya.shape;

public abstract class ImmutableShape implements Comparable<ImmutableShape> {

  protected double metrics;

  @Override
  public String toString() {
    return "norm = " + Double.toString(metrics);
  }

  @Override
  public int compareTo(ImmutableShape other) {
    return Double.compare(metrics, other.metrics);
  }

  protected double getMetrics() {
    return metrics;
  }

  protected abstract double computeMetrics();
}
