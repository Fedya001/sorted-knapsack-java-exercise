package com.fedya.shape;

public class DummyPlainShape extends PlainShape {
  public DummyPlainShape() {
    super(0.0, 0.0);
  }

  @Override
  protected double computeMetrics() {
    return 0;
  }
}
