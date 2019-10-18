package com.fedya.run;

import com.fedya.converter.PlainShapeConverter;
import com.fedya.exception.KnapsackOverflowException;
import com.fedya.exception.ReaderUnknownTypeException;
import com.fedya.gui.GUIManager;
import com.fedya.knapsack.SortedKnapsack;
import com.fedya.shape.*;
import com.fedya.utils.ImmutableShapeReader;
import com.fedya.utils.Pair;
import javax.swing.JPanel;

public class Run {

  public static void main(String[] args) {
    GUIManager guiManager = new GUIManager("Knapsack game", 900, 640);
  }
}
