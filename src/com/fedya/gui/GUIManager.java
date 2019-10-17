package com.fedya.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GUIManager {

  private JLabel mainLabel;
  private JFrame gameFrame;
  private JButton addShapeButton;


  private JLabel logLabel;
  private JTextArea logText;

  private static final Font DEFAULT_APP_FONT = new Font("TimesRoman", Font.BOLD, 20);
  private static final Color DEFAULT_APP_COLOR = new Color(7, 200, 10);

  public GUIManager(String frameName, int width, int height) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        InitFrame(frameName, width, height);
        SetupComponents();
      }
    });
  }

  private void InitFrame(String frameName, int width, int height) {
    gameFrame = new JFrame(frameName);
    gameFrame.setSize(width, height);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setVisible(true);
  }

  private void SetupComponents() {
    gameFrame.setLayout(new BorderLayout());

    mainLabel = new JLabel("Knapsack game 0.1 (beta)", JLabel.CENTER);
    mainLabel.setFont(new Font("TimesRoman", Font.BOLD, 30));
    mainLabel.setForeground(DEFAULT_APP_COLOR);
    gameFrame.getContentPane().add(mainLabel, BorderLayout.NORTH);


    logLabel = new JLabel("Log", JLabel.CENTER);
    logLabel.setFont(DEFAULT_APP_FONT);
    logLabel.setForeground(DEFAULT_APP_COLOR);
    gameFrame.getContentPane().add(logLabel, BorderLayout.WEST);

    logText = new JTextArea();
    logText.setEnabled(false);
    gameFrame.getContentPane().add(logText, BorderLayout.WEST);

    addShapeButton = new JButton("Add shape");
    addShapeButton.setSize(60, 40);
    addShapeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logText.append("done\n");
      }
    });

    gameFrame.add(addShapeButton, BorderLayout.EAST);

  }
}
