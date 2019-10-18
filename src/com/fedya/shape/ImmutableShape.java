package com.fedya.shape;

import java.text.DecimalFormat;

public abstract class ImmutableShape implements Comparable<ImmutableShape> {

  protected double metrics;
  protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

  @Override
  public String toString() {
    return "norm = " + DECIMAL_FORMAT.format(Double.toString(metrics));
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
