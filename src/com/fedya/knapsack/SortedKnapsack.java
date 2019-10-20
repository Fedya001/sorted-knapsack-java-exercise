package com.fedya.knapsack;

import com.fedya.exception.KnapsackOverflowException;
import com.fedya.shape.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedKnapsack {

  private double occupiedVolume;
  private double availableVolume;
  private List<VolumeShape> shapes;
  private boolean isSorted;

  public SortedKnapsack(double availableVolume) {
    this.occupiedVolume = 0.0;
    this.availableVolume = availableVolume;
    shapes = new ArrayList<VolumeShape>();
    isSorted = true;
  }

  public double getOccupiedVolume() {
    return occupiedVolume;
  }

  public double getKnapsackVolume() {
    return availableVolume;
  }

  public void add(VolumeShape shape) throws KnapsackOverflowException {
    if (getOccupiedVolume() + shape.getVolume() <= availableVolume) {
      shapes.add(shape);
      occupiedVolume += shape.getVolume();
      isSorted = false;
    } else {
      throw new KnapsackOverflowException(shape);
    }
  }
  public void removeShape(VolumeShape shape) {
    shapes.remove(shape);
  }

  public List<VolumeShape> asList() {
    if (!isSorted) {
      Collections.sort(shapes);
      isSorted = true;
    }
    return shapes;
  }

  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder("Knapsack[" + getOccupiedVolume()
      + '/' + getKnapsackVolume() + "]\n[\n");

    for (VolumeShape shape : this.asList()) {
      buffer.append('\t').append(shape).append(",\n");
    }

    return buffer.append(']').toString();
  }

  public String getHtmlVolumeDescription() {
    return "<html>Available volume = " + availableVolume +
      "<br/>Occupied volume = " + occupiedVolume + "</html>";
  }
}
