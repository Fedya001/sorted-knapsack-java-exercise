package com.fedya.run;

import com.fedya.exception.KnapsackOverflowException;
import com.fedya.knapsack.SortedKnapsack;
import com.fedya.shape.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Run {
  public static void main(String[] args) {
    final double knapsackVolume = 15.0;

    try {
      SortedKnapsack knapsack = new SortedKnapsack(knapsackVolume) {
        {
          add(new Parallelepiped(1.0, 2.0, 3.0));
          add(new Сylinder(1.0, 2.0));
          add(new Сylinder(0.5, 3.0));
        }
      };

      System.out.println(
        "Knapsack[" + knapsack.getOccupiedVolume()
        + '/' + knapsack.getKnapsackVolume() + "]\n" +
        knapsack.asList()
      );

      knapsack.add(new Parallelepiped(1.0, 1.0, 1.0));
    } catch (KnapsackOverflowException e) {
      e.printStackTrace();
    }
  }
}
