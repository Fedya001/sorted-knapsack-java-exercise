package com.fedya.run;

import com.fedya.gui.GUIManager;
import com.fedya.gui.VolumeInputDialog;
import com.fedya.knapsack.SortedKnapsack;

public class Run {

  public static void main(String[] args) {
    // input knapsack availableVolume
    VolumeInputDialog dialog = new VolumeInputDialog();
    SortedKnapsack knapsack = new SortedKnapsack(dialog.getVolume());

    GUIManager guiManager = new GUIManager(knapsack, "Knapsack game", 900, 640);
  }
}
