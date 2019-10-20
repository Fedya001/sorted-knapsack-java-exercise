package com.fedya.exception;

import com.fedya.shape.ShapeType;

public class UnknownShapeType extends RuntimeException {
  public UnknownShapeType(ShapeType shapeType, String label) {
    super("Generator got unknown type: " + shapeType + ", " + label);
  }
}
