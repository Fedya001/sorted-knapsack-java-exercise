package com.fedya.gui;

import com.fedya.shape.*;
import com.fedya.utils.WindowToolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShapeInputPanelsStorage {

  private static JTextField circleRadiusInputField;

  private static JTextField cylinderRadiusInputField;
  private static JTextField cylinderHeightInputField;

  private static JTextField rectangleWidthInputField;
  private static JTextField rectangleHeightInputField;

  private static JTextField parallelepipedWidthInputField;
  private static JTextField parallelepipedHeightInputField;
  private static JTextField parallelepipedDepthInputField;

  public static final JPanel CIRCLE_INPUT_PANEL = new JPanel() {
    {
      circleRadiusInputField = new JTextField();

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      addTextAreaWithLabel(this, "Radius:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, circleRadiusInputField);
    }
  };

  public static Circle buildCircle() throws NumberFormatException {
    double radius = Double.parseDouble(circleRadiusInputField.getText());
    return new Circle(radius);
  }

  public static final JPanel CYLINDER_INPUT_PANEL = new JPanel() {
    {
      cylinderRadiusInputField = new JTextField();
      cylinderHeightInputField = new JTextField();

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      addTextAreaWithLabel(this, "Radius:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, cylinderRadiusInputField);
      WindowToolkit.separate(this);
      addTextAreaWithLabel(this, "Height:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, cylinderHeightInputField);
    }
  };

  public static Cylinder buildCylinder() throws NumberFormatException {
    double radius = Double.parseDouble(cylinderRadiusInputField.getText());
    double height = Double.parseDouble(cylinderHeightInputField.getText());

    return new Cylinder(radius, height);
  }

  public static final JPanel RECTANGLE_INPUT_PANEL = new JPanel() {
    {
      rectangleWidthInputField = new JTextField();
      rectangleHeightInputField = new JTextField();

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      addTextAreaWithLabel(this, "Width:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, rectangleWidthInputField);
      WindowToolkit.separate(this);
      addTextAreaWithLabel(this, "Height:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, rectangleHeightInputField);
    }
  };

  public static Rectangle buildRectangle() throws NumberFormatException {
    double width = Double.parseDouble(rectangleWidthInputField.getText());
    double height = Double.parseDouble(rectangleHeightInputField.getText());

    return new Rectangle(width, height);
  }

  public static final JPanel PARALLELEPIPED_INPUT_PANEL = new JPanel() {
    {
      parallelepipedWidthInputField = new JTextField();
      parallelepipedHeightInputField = new JTextField();
      parallelepipedDepthInputField = new JTextField();

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      addTextAreaWithLabel(this, "Width:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, parallelepipedWidthInputField);
      WindowToolkit.separate(this);
      addTextAreaWithLabel(this, "Height:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, parallelepipedHeightInputField);
      WindowToolkit.separate(this);
      addTextAreaWithLabel(this, "Depth:",
        GUIManager.DEFAULT_APP_REGULAR_FONT, parallelepipedDepthInputField);
    }
  };

  public static Parallelepiped buildParallelepiped() throws NumberFormatException {
    double width = Double.parseDouble(parallelepipedWidthInputField.getText());
    double height = Double.parseDouble(parallelepipedHeightInputField.getText());
    double depth = Double.parseDouble(parallelepipedDepthInputField.getText());

    return new Parallelepiped(width, height, depth);
  }

  private static void addTextAreaWithLabel(JPanel baselinePanel,
    String labelText, Font font, JTextField textField) {
    JPanel pairedPanel = new JPanel();
    pairedPanel.setLayout(new BoxLayout(pairedPanel, BoxLayout.X_AXIS));

    JLabel label = new JLabel(labelText);
    label.setFont(font);
    pairedPanel.add(label);
    WindowToolkit.separate(pairedPanel);

    textField.setFont(font);
    textField.setMaximumSize(new Dimension(100, 30));
    pairedPanel.add(textField);
    baselinePanel.add(pairedPanel);
  }
}
