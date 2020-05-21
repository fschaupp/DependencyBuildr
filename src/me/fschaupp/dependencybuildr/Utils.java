package me.fschaupp.dependencybuildr;

import java.awt.Dimension;

public interface Utils {
  
  public static Dimension dimensionOf(int width, int height) {
    return new Dimension(width, height);
  }

}
