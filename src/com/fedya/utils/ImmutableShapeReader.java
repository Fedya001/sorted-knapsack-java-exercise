package com.fedya.utils;

import com.fedya.exception.ReaderUnknownTypeException;
import com.fedya.shape.*;
import java.util.Scanner;

public class ImmutableShapeReader {

  public ImmutableShapeReader() {
    scanner = new Scanner(System.in);
  }

  /*
    [This is terrible solution, I know ...
    I didn't have enough time to come up with something better]
    input format:
    1. shape type (available types: Circle, Cylinder, Rectangle, Parallelepiped)
    2. couple of doubles - shape parameters
  */
  public ImmutableShape readShape() throws ReaderUnknownTypeException {
    String type = scanner.next();
    switch (type) {
      case "Circle":
        return new Circle(scanner.nextDouble());
      case "Cylinder":
        return new Cylinder(scanner.nextDouble(), scanner.nextDouble());
      case "Rectangle":
        return new Rectangle(scanner.nextDouble(), scanner.nextDouble());
      case "Parallelepiped":
        return new Parallelepiped(scanner.nextDouble(), scanner.nextDouble(),
          scanner.nextDouble());
      default:
        throw new ReaderUnknownTypeException(type);
    }
  }

  private Scanner scanner;
}
