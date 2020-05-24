package me.fschaupp.dependencybuildr.gui;

import java.util.Optional;

public class LayoutUtils {

  private final static char SPACE = ' ';

  public static String getConstraints(int column, int row) {
    return getConstraints(column, row, Optional.empty(), Optional.empty());
  }

  public static String getConstraints(int column, int row, int width, int height) {
    return getConstraints(column, row, Optional.of(width), Optional.of(height));
  }

  private static String getConstraints(int column, int row, Optional<Integer> width, Optional<Integer> height) {
    StringBuilder layoutString = new StringBuilder();

    layoutString.append(row);
    layoutString.append(SPACE);
    layoutString.append(column);

    if (width.isPresent() && height.isPresent()) {
      layoutString.append(SPACE);

      layoutString.append(height.get());
      layoutString.append(SPACE);

      layoutString.append(width.get());
    }

    return layoutString.toString();
  }

}
