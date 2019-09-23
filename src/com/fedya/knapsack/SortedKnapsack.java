package com.fedya.knapsack;

import com.fedya.exception.KnapsackOverflowException;
import com.fedya.shape.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedKnapsack {

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
      throw new KnapsackOverflowException("Cannot put shape into knapsack", shape);
    }
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
    return "Knapsack[" + getOccupiedVolume()
      + '/' + getKnapsackVolume() + "]\n" +
      asList();
  }

  private double occupiedVolume;
  private double availableVolume;
  private List<VolumeShape> shapes;
  private boolean isSorted;
}
