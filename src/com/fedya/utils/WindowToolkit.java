package com.fedya.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.Box;
import javax.swing.JPanel;

public class WindowToolkit {
  public static void MoveToCenter(Window window) {
    // Move to the center
    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    window.setLocation(screenDim.width/ 2 - window.getSize().width / 2,
      screenDim.height / 2 - window.getSize().height / 2);
  }

  public static void separate(JPanel panel) {
    panel.add(Box.createRigidArea(new Dimension(20, 20)));
  }
}
