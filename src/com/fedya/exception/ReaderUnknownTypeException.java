package com.fedya.exception;

public class ReaderUnknownTypeException extends Exception {

  public ReaderUnknownTypeException(String shapeName) {
    super("Don't know how to read " + shapeName);
  }
}