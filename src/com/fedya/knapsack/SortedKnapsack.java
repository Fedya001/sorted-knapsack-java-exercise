package com.fedya.knapsack;

import com.fedya.shape.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedKnapsack {
  public SortedKnapsack(double volume) {
    this.volume = volume;
    shapes = new ArrayList<VolumeShape>();
    isSorted = true;
  }

  public double getVolume() {
    return volume;
  }

  public void add(VolumeShape shape) {
    shapes.add(shape);
    isSorted = false;
  }

  public List<VolumeShape> asList() {
    if (!isSorted) {
      Collections.sort(shapes);
      isSorted = true;
    }
    return shapes;
  }

  private double volume;
  private List<VolumeShape> shapes;
  private boolean isSorted;
}
