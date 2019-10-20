package com.fedya.run;

import com.fedya.gui.GUIManager;
import com.fedya.knapsack.SortedKnapsack;

public class Run {

  public static void main(String[] args) {
    SortedKnapsack knapsack = new SortedKnapsack(100.0);

    GUIManager guiManager = new GUIManager(knapsack, "Knapsack game", 900, 640);
  }
}
