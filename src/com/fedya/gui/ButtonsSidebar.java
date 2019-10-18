package com.fedya.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class ButtonsSidebar {

  // Design principle: favour composition over inheritance
  private JPanel sidebarPanel;

  ButtonsSidebar(int rows, int cols, int hgap, int vgap, JButton... sidebarButtons) {
    setupInstance(rows, cols, hgap, vgap, sidebarButtons);
  }

  // There are no default parameters in Java :)
  ButtonsSidebar(int rows, int cols, int hgap, int vgap) {
    setupInstance(rows, cols, hgap, vgap);
  }

  private void setupInstance(int rows, int cols, int hgap, int vgap, JButton... sidebarButtons) {
    GridLayout layout = new GridLayout(rows, cols, hgap, vgap);
    sidebarPanel = new JPanel();
    sidebarPanel.setLayout(layout);
    sidebarPanel.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createTitledBorder("Actions"),
      BorderFactory.createLineBorder(Color.BLACK, 7, true)
    ));

    for (JButton button : sidebarButtons) {
      sidebarPanel.add(button);
    }
  }

  JPanel getPanel() {
    return sidebarPanel;
  }

  // TODO: add exception handing, when grid overflow happens
  void addButton(JButton button) {
    sidebarPanel.add(button);
  }

  // TODO: test it
  void removeButton(JButton button) {
    sidebarPanel.remove(button);
  }
}
