package com.fedya.exception;

import com.fedya.shape.ImmutableShape;

public class KnapsackOverflowException extends Exception {

  public KnapsackOverflowException(ImmutableShape notFitShape) {
    super("Knapsack is overflowed, " + notFitShape.toString() + " can't fit");
  }
}
