package com.fedya.gui;

import com.fedya.converter.PlainShapeConverter;
import com.fedya.exception.KnapsackOverflowException;
import com.fedya.exception.UnknownShapeType;
import com.fedya.knapsack.SortedKnapsack;
import com.fedya.shape.Circle;
import com.fedya.shape.ImmutableShape;
import com.fedya.shape.PlainShape;
import com.fedya.shape.Rectangle;
import com.fedya.shape.ShapeType;
import com.fedya.shape.VolumeShape;
import com.fedya.utils.Logger;
import com.fedya.utils.Pair;
import com.fedya.utils.WindowToolkit;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddShapeDialog {

  private SortedKnapsack knapsack;
  private DefaultListModel<String> logModel;
  private PlainShapeConverter shapeConverter;

  // Design principle: favour composition over inheritance :)
  private JDialog dialog;
  private JPanel mainDialogPanel;
  private JComboBox<ShapeType> pickShapeBox;

  private JPanel inputPanel;
  private JButton submitButton;

  AddShapeDialog(SortedKnapsack knapsack, DefaultListModel<String> logModel, JFrame parent) {
    this.knapsack = knapsack;
    this.logModel = logModel;
    shapeConverter = new PlainShapeConverter(new Pair<Double, Double>(0.0, 5.0));

    dialog = new JDialog(parent, "Add shape dialog", true);
    dialog.setPreferredSize(new Dimension(400, 250));
    setupComponents();
    WindowToolkit.MoveToCenter(dialog);
    dialog.pack();
    dialog.setResizable(false);
    dialog.setVisible(true);
  }

  private void setupComponents() {
    mainDialogPanel = new JPanel();
    mainDialogPanel.setLayout(new BoxLayout(mainDialogPanel, BoxLayout.Y_AXIS));

    pickShapeBox = new JComboBox<ShapeType>(ShapeType.values());
    pickShapeBox.addActionListener(event -> {
      ((CardLayout) inputPanel.getLayout())
        .show(inputPanel, ShapeType.values()[pickShapeBox.getSelectedIndex()].toString());
    });
    pickShapeBox.setMaximumSize(new Dimension(300, 30));
    WindowToolkit.separate(mainDialogPanel);
    mainDialogPanel.add(pickShapeBox);
    WindowToolkit.separate(mainDialogPanel);

    inputPanel = new JPanel(new CardLayout());

    inputPanel.add(ShapeInputPanelsStorage.CIRCLE_INPUT_PANEL,
      ShapeType.CIRCLE.name());
    inputPanel.add(ShapeInputPanelsStorage.CYLINDER_INPUT_PANEL,
      ShapeType.CYLINDER.name());
    inputPanel.add(ShapeInputPanelsStorage.RECTANGLE_INPUT_PANEL,
      ShapeType.RECTANGLE.name());
    inputPanel.add(ShapeInputPanelsStorage.PARALLELEPIPED_INPUT_PANEL,
      ShapeType.PARALLELEPIPED.name());

    mainDialogPanel.add(inputPanel);
    WindowToolkit.separate(mainDialogPanel);

    submitButton = new JButton("Submit");
    submitButton.addActionListener(event -> {
      try {
        ImmutableShape shape = GetInputShape();
        if (shape instanceof PlainShape) {
          VolumeShape converted = shapeConverter.stretchShape((PlainShape) shape);
          logModel.addElement(Logger.log("Converted " + shape + " to " + converted));
          logModel.addElement(Logger.log("Add " + shape));
          knapsack.add(converted);
        } else {
          logModel.addElement(Logger.log("Add " + shape));
          knapsack.add((VolumeShape) shape);
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(dialog, "Cannot parse input data",
          "Error", JOptionPane.INFORMATION_MESSAGE);
      } catch (KnapsackOverflowException ex) {
        JOptionPane.showMessageDialog(dialog,
          "Knapsack overflowed.\nConsider decreasing volume",
          "Error", JOptionPane.INFORMATION_MESSAGE);
      } finally {
        dialog.dispose();
      }
    });

    mainDialogPanel.add(submitButton);
    WindowToolkit.separate(mainDialogPanel);

    dialog.add(mainDialogPanel);
  }

  private ImmutableShape GetInputShape() throws NumberFormatException {
    ShapeType selectedType = ShapeType.values()[pickShapeBox.getSelectedIndex()];
    switch (selectedType) {
      case CIRCLE:
        return ShapeInputPanelsStorage.buildCircle();
      case CYLINDER:
        return ShapeInputPanelsStorage.buildCylinder();
      case RECTANGLE:
        return ShapeInputPanelsStorage.buildRectangle();
      case PARALLELEPIPED:
        return ShapeInputPanelsStorage.buildParallelepiped();
      default:
        throw new UnknownShapeType(ShapeType.values()[pickShapeBox.getSelectedIndex()],
          "AddShapeDialog");
    }
  }
}
