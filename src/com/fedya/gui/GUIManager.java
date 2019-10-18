package com.fedya.gui;

import com.fedya.shape.Circle;
import com.fedya.shape.ImmutableShape;
import com.fedya.utils.Logger;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class GUIManager {

  private JLabel mainLabel;
  private JFrame gameFrame;
  private JPanel mainPanel;

  private JLabel logLabel;
  private DefaultListModel<String> logModel;
  private DefaultListModel<ImmutableShape> knapsackStateModel;
  private ButtonsSidebar actionSidebar;

  JButton addShapeButton;
  JButton removeShapeButton;
  JButton clearLogButton;
  JButton switchThemeButton;

  private static final Font DEFAULT_APP_CAPITAL_FONT = new Font("TimesRoman", Font.BOLD, 30);
  private static final Font DEFAULT_APP_REGULAR_FONT = new Font("TimesRoman", Font.BOLD, 16);

  private static final Color DEFAULT_APP_GREEN_COLOR = new Color(7, 200, 10);
  private static final Color DEFAULT_APP_RED_COLOR = new Color(200, 50, 15);

  private boolean appTheme;

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

    appTheme = true;
  }

  private void SetupComponents() {
    gameFrame.setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.Y_AXIS));

    mainLabel = new JLabel("Knapsack game 0.1 (beta)");
    mainLabel.setFont(DEFAULT_APP_CAPITAL_FONT);
    mainLabel.setForeground(DEFAULT_APP_GREEN_COLOR);
    mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    gameFrame.getContentPane().add(mainLabel);

    // 0. main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

    // 1. Buttons sidebar
    JPanel leftSubpanel = new JPanel();
    leftSubpanel.setLayout(new BoxLayout(leftSubpanel, BoxLayout.Y_AXIS));

    addShapeButton = new JButton("Add shape");
    removeShapeButton = new JButton("Remove shape");
    clearLogButton = new JButton("Clear log");
    switchThemeButton = new JButton("Switch app theme");
    setupButtonsListeners();

    actionSidebar = new ButtonsSidebar(2, 2, 20, 20,
      addShapeButton, removeShapeButton, clearLogButton, switchThemeButton);

    leftSubpanel.add(Box.createGlue());
    leftSubpanel.add(actionSidebar.getPanel());
    leftSubpanel.add(Box.createGlue());

    // 2. Log
    logLabel = new JLabel("Log");
    logLabel.setFont(DEFAULT_APP_CAPITAL_FONT);
    logLabel.setForeground(DEFAULT_APP_GREEN_COLOR);
    logLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    logModel = new DefaultListModel<String>();
    JList<String> logList = new JList<String>(logModel);
    logList.setFont(DEFAULT_APP_REGULAR_FONT);
    JScrollPane logScrollPane = new JScrollPane(
      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    logScrollPane.setViewportView(logList);

    leftSubpanel.add(logLabel);
    leftSubpanel.add(logScrollPane);
    leftSubpanel.add(Box.createRigidArea(new Dimension(20, 20)));

    mainPanel.add(leftSubpanel);
    mainPanel.add(Box.createRigidArea(new Dimension(30, 30)));

    // 3. Knapsack state
    knapsackStateModel = new DefaultListModel<ImmutableShape>();
    JList<ImmutableShape> knapsackState = new JList<ImmutableShape>(knapsackStateModel);
    knapsackState.setFont(DEFAULT_APP_REGULAR_FONT);
    JScrollPane stateScrollPane = new JScrollPane(
      ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );
    stateScrollPane.setViewportView(knapsackState);

    knapsackStateModel.addElement(new Circle(4));
    mainPanel.add(stateScrollPane);
    mainPanel.add(Box.createRigidArea(new Dimension(30, 30)));

    gameFrame.getContentPane().setBackground(Color.GRAY);
    gameFrame.getContentPane().add(mainPanel);
  }

  private void setupButtonsListeners() {
    addShapeButton.addActionListener(event -> {
      logModel.addElement(Logger.log("Add"));
    });

    removeShapeButton.addActionListener(event -> {
      logModel.addElement(Logger.log("Remove"));
    });

    clearLogButton.addActionListener(event -> {
      logModel.clear();
    });

    switchThemeButton.addActionListener(event -> {
      logModel.addElement(Logger.log("Switched app theme"));
      setAppTheme();
    });
  }

  private void setAppTheme() {
    if (appTheme) {
      mainLabel.setForeground(DEFAULT_APP_RED_COLOR);
      logLabel.setForeground(DEFAULT_APP_RED_COLOR);
      gameFrame.getContentPane().setBackground(Color.BLACK);
    } else {
      mainLabel.setForeground(DEFAULT_APP_GREEN_COLOR);
      logLabel.setForeground(DEFAULT_APP_GREEN_COLOR);
      gameFrame.getContentPane().setBackground(Color.GRAY);
    }
    appTheme = !appTheme;
  }
}
