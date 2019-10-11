package com.fedya.converter;

import com.fedya.shape.*;
import com.fedya.utils.Pair;
import java.util.HashMap;
import java.util.Random;
import java.util.function.BiFunction;

public class PlainShapeConverter {

  private Pair<Double, Double> stretchRange;
  private HashMap<Class<? extends PlainShape>,
    BiFunction<PlainShape, Double, ? extends VolumeShape>> convertRule;

  public PlainShapeConverter(Pair<Double, Double> stretchRange) {
    this.stretchRange = stretchRange;

    this.convertRule = new HashMap<>() {{
      put(Rectangle.class, (PlainShape rectangle, Double randomDepth) ->
        new Parallelepiped(((Rectangle)rectangle).getWidth(), ((Rectangle)rectangle).getHeight(), randomDepth)
      );
      put(Circle.class, (PlainShape circle, Double randomDepth) ->
        new Cylinder(((Circle)circle).getRadius(), randomDepth)
      );
    }};
  }

  public Pair<Double, Double> getStretchRange() {
    return stretchRange;
  }

  public void setStretchRange(Pair<Double, Double> stretchRange) {
    this.stretchRange = stretchRange;
  }

  public VolumeShape stretchShape(PlainShape plainShape) {
    double randomDepth = new Random().nextDouble() *
      (stretchRange.second - stretchRange.first) + stretchRange.first;
    return convertRule.get(plainShape.getClass()).apply(plainShape, randomDepth);
  }
}
