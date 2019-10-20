package com.fedya.gui;

import com.fedya.utils.WindowToolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VolumeInputDialog extends JDialog {

  private double volume = 100.0;

  public VolumeInputDialog() {
    JPanel mainDialogPanel = new JPanel();
    mainDialogPanel.setLayout(new BoxLayout(mainDialogPanel, BoxLayout.Y_AXIS));

    mainDialogPanel.add(new JLabel("Input knapsack volume:"));
    WindowToolkit.separate(mainDialogPanel);

    JTextField inputField = new JTextField();
    mainDialogPanel.add(inputField);
    WindowToolkit.separate(mainDialogPanel);

    JButton okButton = new JButton("Ok");
    okButton.addActionListener(event -> {
      try {
        volume = Double.parseDouble(inputField.getText());
      } catch (NumberFormatException ex) {
        JOptionPane
          .showMessageDialog(mainDialogPanel, "Cannot parse input data:\n " + ex.getMessage()
            + "\n Default volume of 100.0 will be used",
            "Error", JOptionPane.INFORMATION_MESSAGE);
      } finally {
        this.dispose();
      }
    });
    mainDialogPanel.add(okButton);

    this.add(mainDialogPanel);
    this.pack();
    this.setResizable(false);
    WindowToolkit.MoveToCenter(this);
    this.setModal(true);
    this.setVisible(true);
  }

  public double getVolume() {
    return volume;
  }
}
