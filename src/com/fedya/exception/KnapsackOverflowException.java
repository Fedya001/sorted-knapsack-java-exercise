package com.fedya.exception;

import com.fedya.shape.ImmutableShape;

public class KnapsackOverflowException extends Exception {

  public KnapsackOverflowException(String message, ImmutableShape notFitShape) {
    super(message);
    this.notFitShape = notFitShape;
  }

  @Override
  public String toString() {
    return "Knapsack is overflowed, " + notFitShape.toString() +
      " can't fit [" + getMessage() + "]";
  }

  private ImmutableShape notFitShape;
}
