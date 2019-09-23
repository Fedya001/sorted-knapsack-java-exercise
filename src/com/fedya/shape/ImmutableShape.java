package com.fedya.shape;

public abstract class ImmutableShape implements Comparable<ImmutableShape> {

  protected double getMetrics() {
    return metrics;
  }

  @Override
  public String toString() {
    return "norm = " + Double.toString(metrics);
  }

  @Override
  public int compareTo(ImmutableShape other) {
    return Double.compare(metrics, other.metrics);
  }

  protected abstract double computeMetrics();

  protected double metrics;
}
