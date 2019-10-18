package com.fedya.exception;

import com.fedya.shape.ShapeType;

public class GeneratorUnknownType extends RuntimeException {
  public GeneratorUnknownType(ShapeType shapeType) {
    super("Generator got unknown type: " + shapeType);
  }
}
