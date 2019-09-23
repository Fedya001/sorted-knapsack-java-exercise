package com.fedya.exception;

import com.fedya.shape.PlainShape;

public class ConverterUnknownTypeException extends Exception {

  public ConverterUnknownTypeException(PlainShape failedShape) {
    super("Don't know how to convert " + failedShape.getClass().toString());
  }
}