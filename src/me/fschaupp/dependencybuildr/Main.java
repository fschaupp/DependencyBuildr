package me.fschaupp.dependencybuildr;

import me.fschaupp.dependencybuildr.gui.GUI;

public class Main {

  private static GUI gui;

  public static void main(String[] args) {
    gui = new GUI();
    gui.setVisible(true);
  }

}
